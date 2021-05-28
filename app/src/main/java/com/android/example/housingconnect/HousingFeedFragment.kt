package com.android.example.housingconnect

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_housing_display.*
import kotlinx.android.synthetic.main.fragment_housing_feed.*
import retrofit2.Call
import retrofit2.Response

class HousingFeedFragment : Fragment() {

    // global var for instance of firebase
    private val FirebaseInstance = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_housing_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: PHASE 3.1 - Connect adapter and layoutManager to the RecyclerView defined in xml
        val housingAdapter = HousingListAdapter()
        screen1.adapter = housingAdapter
        screen1.layoutManager = LinearLayoutManager(requireContext())

        // TODO: PHASE 3.1 - Add onClickListener to Post Button and navigate to signin page or
        //  the start of the form (FormLocationFragment)
        var user = FirebaseInstance.currentUser
        FirebaseInstance.currentUser?.photoUrl
        post.setOnClickListener {
            if(user == null) {
                // go to sign in page
                val action = R.id.action_housingFeedFragment_to_signInFragment
                findNavController().navigate(action)
            } else {
                // go to forms
                val action = R.id.action_housingFeedFragment_to_formLocationFragment
                findNavController().navigate(action)
            }
        }

        // TODO: PHASE 4 - Get an instance of the singleton housingService defined in the MainActivity
        val housingService = (requireActivity() as MainActivity).housingService

        // TODO: PHASE 4 - using the housingService to fetch all Housing Listing from the server
        //  make sure to update the recycler views adapter
        housingService.getAll().enqueue(object: retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: retrofit2.Response<List<Post>>) {
                Log.d("HousingFeedFragment", "Success in onResponse")

                    housingAdapter.setData(response.body()!!)


            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("HousingFeedFragment", "Success in onFailure")
                Log.d("HousingFeedFragment", t.toString())
            }
        })

    }
}

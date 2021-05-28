package com.android.example.housingconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_form_location.*

class FormLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PHASE 3.2 - when a user clicks 'continue' navigate the user to the FormDetailsFragment
        //  and send the data the user has filled in so far. the recommended way is to send a Post object
        val location: TextInputLayout = view.findViewById(R.id.location)
        val city: TextInputLayout = view.findViewById(R.id.city)
        val state: TextInputLayout = view.findViewById(R.id.state)
        val stateoptions: AutoCompleteTextView = view.findViewById(R.id.Stateoptions)

        val string = arrayListOf<String>("AL" ,"AK", "AZ",
                "AR",
               "CA",
                "CO",
                "CT",
                "DE",
                "DC",
                "FL",
                "GA",
                "HI",
                "ID",
                "IL",
                "IN",
                "IA",
                "KS",
                "KY",
                "LA",
                "ME",
                "MD",
                "MA",
                "MI",
                "MN",
                "MS",
                "MO",
                "MT",
                "NE",
                "NV",
                "NH",
                "NJ",
                "NM",
                "NY",
                "NC",
                "ND",
                "OH",
                "OK",
                "OR",
                "PA",
                "RI",
                "SC",
               "SD",
                "TN",
               "TX",
                "UT",
                "VT",
                "VA",
                "WA",
                "WV",
                "WI",
                "WY")


        val arrayadapter = context?.let { ArrayAdapter<String>(it,R.layout.dropdown_states,string) }

        stateoptions.setAdapter(arrayadapter)

        continueBtn.setOnClickListener{
            val action = FormLocationFragmentDirections.actionFormLocationFragmentToFormDetailsFragment(location.editText?.text.toString() +
                    ", " + city.editText?.text.toString() + ", " + state.editText?.text.toString())
            findNavController().navigate(action)
        }


    }
}
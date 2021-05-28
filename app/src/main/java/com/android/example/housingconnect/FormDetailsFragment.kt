package com.android.example.housingconnect

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_form_details.*
import kotlinx.android.synthetic.main.fragment_form_details.housingType
import kotlinx.android.synthetic.main.fragment_form_location.*
import kotlinx.android.synthetic.main.housing_list_item.*

class FormDetailsFragment : Fragment() {

    private val args: FormDetailsFragmentArgs by navArgs()
    //private lateinit var arraylist_house: ArrayList<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_details, container, false)
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PHASE 3.2 - when a user clicks 'continue' navigate the user to the FormDescriptionFragment
        //  and send the data the user has filled in so far. the recommended way is to send a Post object
        val housingType: TextInputLayout = view.findViewById(R.id.housingType)
        val bedrooms: TextInputLayout = view.findViewById(R.id.bedrooms)
        val bathrooms: TextInputLayout = view.findViewById(R.id.bathrooms)
        val rent: TextInputLayout = view.findViewById(R.id.rent)
        val movein: TextInputLayout = view.findViewById(R.id.movein)
        val houseoptions: AutoCompleteTextView = view.findViewById(R.id.housingoptions)

        val string = arrayListOf<String>("Townhome", "House", "Apartment")
         val arrayadapter = context?.let { ArrayAdapter<String>(it,R.layout.dropdown_type,string) }

        houseoptions.setAdapter(arrayadapter)

        continueBtnDetails.setOnClickListener {
            println(rent.editText?.text)
            val action =
                FormDetailsFragmentDirections.actionFormDetailsFragmentToFormDescriptionFragment2(
                    args.locationPass,
                    housingType.editText?.text.toString(),
                    Integer.parseInt(bedrooms.editText?.text.toString()),
                    Integer.parseInt(bathrooms.editText?.text.toString()),
                    Integer.parseInt(rent.editText?.text.toString()),
                    movein.editText?.text.toString()
                )
            findNavController().navigate(action)
        }
    }
}
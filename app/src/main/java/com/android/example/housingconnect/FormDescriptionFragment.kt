package com.android.example.housingconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_form_description.*
import kotlinx.android.synthetic.main.fragment_form_details.*

class FormDescriptionFragment : Fragment() {

    private val args: FormDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PHASE 3.2 - when a user clicks 'continue' navigate the user to the FormImageFragment
        //  and send the data the user has filled in so far. the recommended way is to send a Post object

        val description: TextInputLayout = view.findViewById(R.id.description)
        continueBtnDesc.setOnClickListener {
            var check = "false"
            if (covidTestedCheck.isChecked.toString() == "true") {
                check = "true"
            }
            val action =
                FormDescriptionFragmentDirections.actionFormDescriptionFragment2ToFormImageFragment(
                    args.locationPassAgain,
                    args.typePass,
                    args.bedPass,
                    args.bathPass,
                    args.pricePass,
                    args.moveInPass,
                    description.editText?.text.toString(),
                    check
                )
            findNavController().navigate(action)
        }
    }
}
package com.android.example.housingconnect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_housing_display.*


class HousingDisplayFragment : Fragment() {

    private val args: HousingDisplayFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_housing_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PHASE 3.3 - Use Glide to display the image stored in the Post
        Glide.with(view)
            .load("https://Project-3-RentWell-Server.ruiyihe.repl.co" + args.housingClicked.image)
            .into(housingImageClicked)

        // TODO: PHASE 3.3 - Dynamically update information showing in the xml using the Post object data fields
        housingType.text = args.housingClicked.type
        address.text = args.housingClicked.location.substring(0, args.housingClicked.location.indexOf(", "))
        //addressState.text = args.housingClicked.location.substring(args.housingClicked.location.indexOf("//")+1, args.housingClicked.location.length)
        addressState.text = args.housingClicked.location.substring(args.housingClicked.location.indexOf(", ")+2, args.housingClicked.location.length)
        price.text = args.housingClicked.price.toString()
        numOfBeds.text = args.housingClicked.bed.toString()
        numOfBaths.text = args.housingClicked.bath.toString()
        desc.text = args.housingClicked.desc
        date.text = args.housingClicked.moveIn
        datepublished.text = datepublished.text.toString()
                .plus( args.housingClicked.date)


        if(args.housingClicked.covidTested == "true") {
            covidTestedYes.visibility = View.VISIBLE
            covidTestedNo.visibility = View.GONE
        } else {
            covidTestedYes.visibility = View.GONE
            covidTestedNo.visibility = View.VISIBLE
        }

        // TODO: PHASE 3.3 - Create an onclick listener on a button to send an email.
        //  this stage will require sending an implicit intent to an email application.
        //  recall that you can find common intents on the android documentation
        email.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, args.housingClicked.email)
                putExtra(Intent.EXTRA_SUBJECT, "")
                putExtra(Intent.EXTRA_STREAM, "")
            }
            startActivity(intent)
        }
    }
}
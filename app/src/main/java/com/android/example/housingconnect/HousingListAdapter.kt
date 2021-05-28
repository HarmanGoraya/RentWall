package com.android.example.housingconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_housing_display.*

class HousingListAdapter() : RecyclerView.Adapter<ItemViewHolder>() {

    private var posts = emptyList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.housing_list_item, parent, false)
       return ItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = posts[position]
        holder.apply {
            // TODO: PHASE 3.1 - Re-define these values based on the the post object being displayed
            housingType.text = item.type
            //location.text = item.location.substring(0, item.location.indexOf("//"))
            println(item.location.indexOf(", ",0))
            location.text = item.location.substring(0, item.location.indexOf(", "))
            state.text = item.location.substring(item.location.indexOf(", ")+2, item.location.length)
            price.text = item.price.toString()
            numOfBeds.text = item.bed.toString()
            numOfBaths.text = item.bath.toString()
            //covidTested.text = item.covidTested

            if(item.covidTested == "true") {
                covidTestedYes.visibility = View.VISIBLE
                covidTestedNo.visibility = View.GONE
            } else {
                covidTestedYes.visibility = View.GONE
                covidTestedNo.visibility = View.VISIBLE
            }

            //description.text = item.desc
           // moveIn.text = item.moveIn

            // TODO: PHASE 3.1 Use Glide to show an image from the database
             Glide.with(holder.itemView)
                .load("https://Project-3-RentWell-Server.ruiyihe.repl.co" + item.image)
                .into(housingImage)
        }

        holder.housingItem.setOnClickListener{
            // TODO: PHASE 3.1 navigate to HousingDisplayFragment and send the Post object
            val action = HousingFeedFragmentDirections.actionHousingFeedFragmentToHousingDisplayFragment(Post(posts[position].id, posts[position].email,
                    posts[position].type, posts[position].bed, posts[position].bath, posts[position].price, posts[position].covidTested, posts[position].moveIn,
                    posts[position].location, posts[position].desc, posts[position].date, posts[position].image))
            NavHostFragment.findNavController(it.findFragment()).navigate(action)
            
        }
    }

    override fun getItemCount() = posts.size

    fun setData(newPosts: List<Post>) {
        posts = newPosts
        this.notifyDataSetChanged()
    }
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val housingItem: ConstraintLayout = view.findViewById(R.id.housingItem)
    val housingImage: ImageView = view.findViewById(R.id.housingImage)
    val housingType: TextView = view.findViewById(R.id.housingType)
    val location: TextView = view.findViewById(R.id.address)
    val state: TextView = view.findViewById(R.id.addressState)
    val price: TextView = view.findViewById(R.id.price)
    val numOfBeds: TextView = view.findViewById(R.id.numOfBeds)
    val numOfBaths: TextView = view.findViewById(R.id.numOfBaths)
    val covidTested: TextView = view.findViewById(R.id.covidTested)
    val covidTestedYes: ImageView = view.findViewById(R.id.covidTestedYes)
    val covidTestedNo: ImageView = view.findViewById(R.id.covidTestedNo)

    //val description: TextView = view.findViewById(R.id.desc)
//    val moveIn: TextView = view.findViewById(R.id.date)
}
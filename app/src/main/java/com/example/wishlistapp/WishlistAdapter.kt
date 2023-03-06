package com.example.wishlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val items: MutableList<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val price: TextView
        val link: TextView

        init {
            name = itemView.findViewById<TextView>(R.id.itemName)
            price = itemView.findViewById<TextView>(R.id.itemPrice)
            link = itemView.findViewById<TextView>(R.id.itemLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Copied from Email Project
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Copied from Email Project
        // Get the data model based on position
        val item = items[position]
        // Set item views based on views and data model
        holder.name.text = item.name
        holder.price.text = item.price
        holder.link.text = item.link
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

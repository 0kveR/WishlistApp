package com.example.wishlistapp

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val items: MutableList<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    var listener: OnItemClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val price: TextView
        val link: TextView
        private val bgs = intArrayOf(R.drawable.background_blue, R.drawable.background_lilac, R.drawable.background_green,
            R.drawable.background_red, R.drawable.background_orange, R.drawable.background_yellow)

        init {
            name = itemView.findViewById<TextView>(R.id.itemName)
            price = itemView.findViewById<TextView>(R.id.itemPrice)
            link = itemView.findViewById<TextView>(R.id.itemLink)
            itemView.setBackgroundResource(bgs.random())
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
        val item = items[position]

        holder.itemView.setOnLongClickListener {
            listener?.onItemClick(position)
            true
        }
        holder.name.text = item.name
        holder.price.text = item.price
        holder.link.text = item.link
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

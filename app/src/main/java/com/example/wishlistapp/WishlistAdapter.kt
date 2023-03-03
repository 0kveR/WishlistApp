package com.example.wishlistapp

class WishlistAdapter {
    class ViewHolder(wishlist: Wishlist) {
        val name: String
        val price: Double
        val link: String

        init {
            name = wishlist.name
            price = wishlist.price
            link = wishlist.link
        }
    }
}
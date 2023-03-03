package com.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlistapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var background: ConstraintLayout
    private lateinit var addBtn: Button
    private lateinit var addName: EditText
    private lateinit var addPrice: EditText
    private lateinit var addLink: EditText
    private lateinit var wishlistRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.let {
            background = it.background
            addBtn = it.addButton
            addName = it.addName
            addPrice = it.addPrice
            addLink = it.addLink
            wishlistRV = it.wishlistRV
        }

        addBtn.setOnClickListener {
            if (addName.text.isBlank() || addPrice.text.isBlank() || addLink.text.isBlank()) {
                Snackbar.make(background, "Please enter all fields.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }


        }
    }
}
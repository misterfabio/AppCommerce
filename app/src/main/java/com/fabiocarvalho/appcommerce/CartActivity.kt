package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CartActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView

    //  On-Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

//----> Configura toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.cart_title)

        val fragment = CartFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_cart, fragment).commit()

    }

    //  OnBackPressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.fabiocarvalho.appcommerce.viewmodel.CartViewModel

class CartActivity : AppCompatActivity(), CartFragment.Callback {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var cartTotal: TextView

    private val cartViewModel by viewModels<CartViewModel>()

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

        cartTotal = findViewById(R.id.tv_total)

        cartViewModel.cartPrice.observe(this, androidx.lifecycle.Observer {
            cartTotal.text = "R$ ${it}"
        })

        val fragment = CartFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_cart, fragment).commit()

    }

    //  OnBackPressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun updateCart() {
        cartViewModel.cartPrice.value = CartViewModel.order.price
    }
}
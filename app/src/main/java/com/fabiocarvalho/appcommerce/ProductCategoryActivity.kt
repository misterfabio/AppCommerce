package com.fabiocarvalho.appcommerce

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.fabiocarvalho.appcommerce.models.ProductCategory

class ProductCategoryActivity : AppCompatActivity(), ProductCategoryFragment.Callback {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    var isTablet: Boolean = false

    //  On-Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_category)

//----> Configura toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.product_category_title)

        isTablet = findViewById<View>(R.id.fragment_product) != null

    }

    //  OnBackPressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun itemSelected(category: ProductCategory) {
        if (isTablet) {
            val args = Bundle()
            args.putSerializable("CATEGORY", category)
            val fragment = ProductFragment()
            fragment.arguments = args
            supportFragmentManager.beginTransaction().replace(R.id.fragment_product, fragment).commit()
        }else{
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("CATEGORY", category)
            startActivity(intent)
        }
    }

}
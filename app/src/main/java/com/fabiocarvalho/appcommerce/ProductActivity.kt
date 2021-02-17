package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.adapters.ProductCategoryAdapter
import com.fabiocarvalho.appcommerce.models.ProductCategory

class ProductActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView

    //  On-Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

//----> Configura toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.product_title)

        val category  = intent.getSerializableExtra("CATEGORY") as ProductCategory
        val args = Bundle()
        args.putSerializable("CATEGORY", category)
        val fragment = ProductFragment()
        fragment.arguments = args
        supportFragmentManager.beginTransaction().replace(R.id.fragment_product, fragment).commit()

    }

    //  OnBackPressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
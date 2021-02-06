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

class ProductCategoryActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var recyclerCategory: RecyclerView

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



        recyclerCategory = findViewById(R.id.rv_product_category)
        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory("1",
            "Camisas"), ProductCategory("2", "Calças") , ProductCategory("2", "Meias"),
            ProductCategory("2", "Calçados")
        )
        val adapterCategory = ProductCategoryAdapter(arrayCategory,this)
        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(this,2)


    }

    //  OnBackPressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
package com.fabiocarvalho.appcommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.adapters.ProductAdapter
import com.fabiocarvalho.appcommerce.adapters.ProductCategoryAdapter
import com.fabiocarvalho.appcommerce.models.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var textLogin: TextView
    lateinit var recyclerCategory: RecyclerView
    lateinit var recyclerProduct: RecyclerView

//  On-Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//----> Configura toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.app_name)

//----> Configura o menu drawer
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        drawerLayout = findViewById(R.id.nav_drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.toggle_open, R.string.toggle_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

        // Recycler View Produto - categorias
        recyclerCategory = findViewById(R.id.rv_main_product_category)
        val arrayCategory = arrayListOf<ProductCategory>(ProductCategory("1",
            "Camisas"), ProductCategory("2", "Calças") , ProductCategory("2", "Meias"),
                ProductCategory("2", "Calçados")
        )
        val adapterCategory = ProductCategoryAdapter(arrayCategory,this)
        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        // Recycler View Produtos
        recyclerProduct = findViewById(R.id.rv_main_product)
        val adapterProduct = ProductAdapter(fillRvProduct(), this)
        recyclerProduct.adapter = adapterProduct
        recyclerProduct.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

    }

    fun fillRvProduct() : List<Product>{
        val product1: Product = Product(
            "1",
            "Camisa 89",
            ProductCategory("id", "Camisas"),
            "Camisa social 1",
            120.2,
            arrayListOf(ProductColor("1","Branca","#ffffff"), ProductColor("2","Preta","#000000")),
            arrayListOf(ProductSize("1", "P"), ProductSize("1", "M"), ProductSize("1", "G")),
            emptyList())
        val product2: Product = Product(
            "2",
            "Calça Jeans",
            ProductCategory("id", "Calças"),
            "Calça social 1",
            50.99,
            arrayListOf(ProductColor("1","Branca","#ffffff"), ProductColor("2","Preta","#000000")),
            arrayListOf(ProductSize("1", "P"), ProductSize("1", "M"), ProductSize("1", "G")),
            emptyList())

        return arrayListOf(product1,product2)
    }

//  Quando clica na tecla de voltar
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

//  Quando clica em um dos itens do menu drawer
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_account -> {
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_category -> {
                val intent = Intent(this, ProductCategoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_orders -> Toast.makeText(this, "Minhas compras", Toast.LENGTH_LONG).show()
            R.id.nav_cart -> Toast.makeText(this, "Meu carrinho", Toast.LENGTH_LONG).show()
            R.id.nav_logout -> Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

}
//==========================================[ fim ]===============================================//
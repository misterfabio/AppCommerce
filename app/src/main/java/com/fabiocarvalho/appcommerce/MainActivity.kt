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
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var textTitle: TextView

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

//----> Quando clica no produto vai para a activity correspondente
        val productItem: LinearLayout = findViewById(R.id.ll_product_item)
        productItem.setOnClickListener{
            val intent: Intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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
            R.id.nav_account -> Toast.makeText(this, "Minha conta", Toast.LENGTH_LONG).show()
            R.id.nav_category -> Toast.makeText(this, "Categorias", Toast.LENGTH_LONG).show()
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
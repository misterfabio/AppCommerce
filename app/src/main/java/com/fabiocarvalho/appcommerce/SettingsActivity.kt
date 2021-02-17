package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.fabiocarvalho.appcommerce.models.ProductCategory

class SettingsActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView

    //  On-Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

//----> Configura toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.settings_title)

    }

    //  OnBackPressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
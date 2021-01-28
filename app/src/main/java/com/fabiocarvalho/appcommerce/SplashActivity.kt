package com.fabiocarvalho.appcommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        val intent: Intent = Intent(this, MainActivity::class.java)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(intent)
            finish()
        }, 3000)

    }
}
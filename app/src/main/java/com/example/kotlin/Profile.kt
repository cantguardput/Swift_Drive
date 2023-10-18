package com.example.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Profile : AppCompatActivity(), View.OnClickListener {

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnLogout: TextView = findViewById(R.id.logout)
        btnLogout.setOnClickListener(this)

        val btnPesanan: TextView = findViewById(R.id.pesanan)
        btnPesanan.setOnClickListener(this)

        val btnPromo: TextView = findViewById(R.id.promo)
        btnPromo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.logout -> {
                val intent = Intent(this@Profile, LoginActivity::class.java)
                resultLauncher.launch(intent)
            }
            R.id.pesanan -> {
                val intent = Intent(this@Profile, Pesanan::class.java)
                resultLauncher.launch(intent)
            }

            R.id.promo -> {
                val intent = Intent(this@Profile, Promo::class.java)
                resultLauncher.launch(intent)
            }
        }
    }
}
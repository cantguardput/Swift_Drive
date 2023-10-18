package com.example.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Pesanan : AppCompatActivity(), View.OnClickListener  {

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)

        val btnOke: TextView = findViewById(R.id.oke)
        btnOke.setOnClickListener(this)
    }
    override fun onClick(v: View) {
    when (v.id) {
        R.id.oke -> {
            val intent = Intent(this@Pesanan, Profile::class.java)
            resultLauncher.launch(intent)
        }
    }
}
}
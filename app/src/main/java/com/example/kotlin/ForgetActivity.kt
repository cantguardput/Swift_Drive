package com.example.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class ForgetActivity : AppCompatActivity(),  View.OnClickListener {
    private lateinit var etEmail: EditText

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)
        etEmail = findViewById(R.id.edt_email)
        val bundle = intent.extras
        if (bundle != null){
            etEmail.setText(bundle.getString("Email"))
        }
        val btnSend : Button = findViewById(R.id.btn_send)
        btnSend.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_send -> {
                val intent = Intent(this@ForgetActivity, Verif::class.java)
                intent.putExtra("User",User(etEmail.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}
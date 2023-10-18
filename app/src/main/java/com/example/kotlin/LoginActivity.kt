package com.example.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.edt_email)
        etPassword = findViewById(R.id.edt_password)


        val bundle = intent.extras
        if (bundle != null){
            etEmail.setText(bundle.getString("Email"))
            etPassword.setText(bundle.getString("Password"))
        }

        val btnLogin : Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

        val btnForget : Button = findViewById(R.id.btn_forget)
        btnForget.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, Homepage::class.java)
                intent.putExtra("User",User(etEmail.text.toString()))
                resultLauncher.launch(intent)
            }

            R.id.btn_forget -> {
                val intent = Intent(this@LoginActivity, ForgetActivity::class.java)
                intent.putExtra("User",User(etEmail.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}
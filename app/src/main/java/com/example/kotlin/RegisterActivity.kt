package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var etEmail:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.edt_username)
        etPassword = findViewById(R.id.edt_password)
        etEmail = findViewById(R.id.edt_email)

        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_register -> {

                val bundle = Bundle()
                bundle.putString("Username", etUsername.text.toString())
                bundle.putString("Password", etPassword.text.toString())
                //bundle.putString("Comfirm Password", etCofirmPassword.text.toString())


                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

    }
}
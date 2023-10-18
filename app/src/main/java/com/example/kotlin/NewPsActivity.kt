package com.example.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class NewPsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etPassword:EditText
    private lateinit var etPassword2:EditText
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_ps)
        etPassword = findViewById(R.id.edt_password)
        etPassword2 = findViewById(R.id.edt_password2)
        val bundle = intent.extras
        if (bundle != null){
            etPassword.setText(bundle.getString("Password"))
            etPassword2.setText(bundle.getString("Password"))
        }
        val btnNewPs : Button = findViewById(R.id.btn_newps)
        btnNewPs.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_newps -> {
                val intent = Intent(this@NewPsActivity, LoginActivity::class.java)
                intent.putExtra("Password", etPassword2.toString())
                resultLauncher.launch(intent)
            }
        }
    }
}
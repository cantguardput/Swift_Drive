package com.example.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class Verif : AppCompatActivity(), View.OnClickListener {

    private lateinit var etOtp: EditText
    private lateinit var etOtp1: EditText
    private lateinit var etOtp2: EditText
    private lateinit var etOtp3: EditText
    private lateinit var etOtp4: EditText

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verif)
        etOtp= findViewById(R.id.edt_otp1)
        etOtp1= findViewById(R.id.edt_otp2)
        etOtp2= findViewById(R.id.edt_otp3)
        etOtp3= findViewById(R.id.edt_otp4)
        etOtp4= findViewById(R.id.edt_otp5)
        val bundle = intent.extras
        if (bundle != null){
            etOtp.setText(bundle.getString("OTP"))
        }
        val btnVerif : Button = findViewById(R.id.btn_sendkode)
        btnVerif.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_sendkode -> {
                val intent = Intent(this@Verif, NewPsActivity::class.java)
                intent.putExtra("OTP",User(etOtp.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}
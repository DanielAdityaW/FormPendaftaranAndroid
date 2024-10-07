package com.bcafbootcamp.aplikasiabsensi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class login : AppCompatActivity() {

    private lateinit var btnLogin:Button
    private lateinit var btnDaftar:Button
    private lateinit var imageLogo:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        var txtUsername = findViewById<EditText>(R.id.txtUsername)
        val txtPassword = findViewById<EditText>(R.id.editTextTextPassword)
        imageLogo = findViewById(R.id.imageView)

        val bcafinance = findViewById<TextView>(R.id.labelbcafinance)

        bcafinance.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://bcafinance.co.id"))
            startActivity(intent)
        }

        btnLogin = findViewById(R.id.btnLogin)
        btnDaftar = findViewById(R.id.btnDaftar)

        btnLogin.setOnClickListener {
            Toast.makeText(this, "Username: ${txtUsername.text}, Password: " +
            "${txtPassword.text}", Toast.LENGTH_LONG).show()
            loadAnim()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", txtUsername.text.toString())
            startActivity(intent)
        }

        btnDaftar.setOnClickListener {
            val intent = Intent(this, FormPendaftaran::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Resume", Toast.LENGTH_LONG).show()
        loadAnim()
    }

    fun loadAnim(){
        val animateLogo = AnimationUtils.loadAnimation(this, R.anim.logorotation)
        imageLogo.startAnimation(animateLogo)
    }
}
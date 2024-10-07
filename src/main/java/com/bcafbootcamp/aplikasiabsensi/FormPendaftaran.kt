package com.bcafbootcamp.aplikasiabsensi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormPendaftaran : AppCompatActivity() {

    private lateinit var buttondaftar: Button

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_pendaftaran)

        var nama = findViewById<EditText>(R.id.namaform)
        val pass = findViewById<EditText>(R.id.passform)
        var email = findViewById<EditText>(R.id.emailform)
        val alamat = findViewById<EditText>(R.id.alamatfrom)

        buttondaftar = findViewById(R.id.buttondaftar)

        buttondaftar.setOnClickListener {
            Toast.makeText(this, "Username: ${nama.text}, Password: " +
                    "${pass.text}, Email: ${email.text}, alamat: ${alamat.text}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
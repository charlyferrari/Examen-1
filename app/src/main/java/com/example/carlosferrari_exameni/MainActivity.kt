package com.example.carlosferrari_exameni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var buttonContinue: Button
    private lateinit var nombreEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonContinue = findViewById(R.id.button)
        nombreEditText = findViewById(R.id.nombreEditText)

        buttonContinue.setOnClickListener {
            val nombreAlumno = nombreEditText.text.toString()

            if (nombreEditText.text.isNullOrEmpty()) {

                Toast.makeText(this, "Ingrese un nombre para continuar", Toast.LENGTH_SHORT).show()
            } else {
                val userName: String = nombreAlumno
                val preferences = getSharedPreferences("appPreference", MODE_PRIVATE)
                val editor = preferences.edit().putString("LO", userName)
                editor.apply()

                val intent = Intent(this, SecondActivity::class.java)
                //intent.putExtra("nombreAlumno", nombreAlumno)
                startActivity(intent)
            }


        }
    }
}
package com.example.carlosferrari_exameni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var textViewEdad: TextView
    private lateinit var textViewId: TextView
    private lateinit var  ImagenView: ImageView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewNombreDetail)
        textViewEdad = findViewById(R.id.textViewEdadDetail)
        textViewId = findViewById(R.id.textViewIdDetail)
        ImagenView = findViewById(R.id.imageView)
        button = findViewById(R.id.Atras)

        val bundle = intent.extras
        val nombre = bundle?.getString("name") ?:""
        val edad = bundle?.getString("age") ?:""
        val id = bundle?.getString("id") ?:""
        val url = bundle?.getString("url") ?:""

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        textViewName.text = nombre
        textViewEdad.text= edad
        textViewId.text = id
        Glide.with(applicationContext)
            .load(url)
            .into(ImagenView)

    }
}
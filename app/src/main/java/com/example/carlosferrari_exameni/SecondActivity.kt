package com.example.carlosferrari_exameni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private lateinit var alumnosRecyclerView: RecyclerView
    private lateinit var adapter: AlumnoAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //val bundle = intent.extras
        //val editName = bundle?.getString("name", "")

        // TOMO EL VALOR DEL EDITTEXT POR SHARED PREFERENCE
        //val preferences = getSharedPreferences("appPreference", MODE_PRIVATE)
        //val userName = preferences.getString("name","")

        alumnosRecyclerView = findViewById(R.id.alumnosRecyclerView)
        alumnosRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AlumnoAdapter(applicationContext)

        alumnosRecyclerView.adapter = adapter

        adapter.submitList(getListadoAlumnos())

        adapter.onItemClickListener = {alumno ->
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("id",alumno.id )
            intent.putExtra("name",alumno.name)
            intent.putExtra("age",alumno.edad)
            intent.putExtra("url",alumno.url)
            startActivity(intent)

        }

    }

    private fun getListadoAlumnos(): MutableList<Alumno>? {

        // TOMO EL VALOR DEL EDITTEXT POR SHARED PREFERENCE
        val preferences = getSharedPreferences("appPreference", MODE_PRIVATE)
        val userName = preferences.getString("namePref","")

        return mutableListOf(
            Alumno(
                1,
                userName.toString(),
                28,
                "https://upload.wikimedia.org/wikipedia/commons/2/2c/Camilo_Echeverry_-_Hombre_de_hojalata.png"
            ),
            Alumno(
                2,
                "Santiago Romero",
                36,
                "https://upload.wikimedia.org/wikipedia/commons/7/72/Hombres_trabajando_en_Emboscada3.jpg"
            ),
            Alumno(
                3,
                "Gerardo Martinez",
                23,
                "https://upload.wikimedia.org/wikipedia/commons/6/61/Hombres_trabajando_en_la_Fabrica_de_ceramica5.jpg"
            ),
            Alumno(
                4,
                "Enrique Diaz",
                32,
                "https://upload.wikimedia.org/wikipedia/commons/2/2f/2013-08-25_Chiemsee_Reggae_Summer_-_Gentleman_6500-cropped.JPG"
            ),
            Alumno(
                5,
                "Valeria Alvarez",
                40,
                "https://upload.wikimedia.org/wikipedia/commons/4/48/Outdoors-man-portrait_%28cropped%29.jpg"
            ),
            Alumno(
                6,
                "Carla Perez",
                40,
                "https://upload.wikimedia.org/wikipedia/commons/c/ca/Gentleman_chanteur.jpg"
            ),
            Alumno(
                7,
                "Ricardo Diez",
                43,
                "https://upload.wikimedia.org/wikipedia/commons/a/ad/Old_man%2C_Bihar%2C_India%2C_04-2012.jpg"
            ),
            Alumno(
                8,
                "Diego Diaz",
                20,

                "https://upload.wikimedia.org/wikipedia/commons/d/df/Man_arms.jpg"
            ),
            Alumno(
                9,
                "Leo Luna",
                24,
                "https://commons.wikimedia.org/wiki/File:Sikh_man,_Agra_10.jpg"
            ),
            Alumno(
                10,
                "Hernan Lucero",
                40,
                "https://upload.wikimedia.org/wikipedia/commons/3/38/Young_man%2C_studio_portrait.jpg"
            ),
        )

    }


}
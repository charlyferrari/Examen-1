package com.example.carlosferrari_exameni

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnoAdapter(val context: Context) :
    ListAdapter<Alumno, AlumnoAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Alumno) -> Unit


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.textViewNombre)
        private val edad: TextView = view.findViewById(R.id.textViewEdad)
        private val imagenFoto: ImageView = view.findViewById(R.id.imageViewFoto)

        fun bind(alumno: Alumno) {
            name.text = "Nombre:" + alumno.name.toString()
            edad.text = "Edad: " + alumno.edad.toString()



            //Glide permite ir a buscar las imageenes en la web
            Glide.with(context)
                .load(alumno.url)
                .into(imagenFoto)

             view.setOnClickListener {
                 onItemClickListener(alumno)
             }


        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlumnoAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_alumno, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoAdapter.ViewHolder, position: Int) {
        val alumnos = getItem(position)
        holder.bind(alumnos)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alumno>() {
        override fun areItemsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem == newItem
        }
    }


}


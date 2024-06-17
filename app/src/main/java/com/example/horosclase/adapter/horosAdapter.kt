package com.example.horosclase.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.R
import com.example.horosclase.horoscopoclass


class horosAdapter(private var dataSet:List<horoscopoclass>, private val onItemClickListener:(Int)->Unit):RecyclerView.Adapter<horosViewHolder>() {
    // Este método se llama para crear nuevas celdas,
    // y se crear las justas para mostrar en pantalla,
    // Ya que intentará reciclar las que no se vean

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): horosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horoscopo, parent, false)

        return horosViewHolder(view)
    }




    // Este método simplemente es para decir cuantos elementos queremos mostrar
    override fun getItemCount(): Int = dataSet.size


    // Este método se llama cada vez que se va a visualizar una celda,
    // y lo utilizaremos para mostrar los datos de esa celda
    override fun onBindViewHolder(
        holder: com.example.horosclase.adapter.horosViewHolder,
        position: Int
    ) {
        holder.render(dataSet[position])
        holder.itemView.setOnClickListener {
            onItemClickListener(position)
        }

    }

    // Este método sirve para actualizar los datos
    fun  updateDate (newDataset: List<horoscopoclass>){
        dataSet = newDataset
        notifyDataSetChanged()
    }




}











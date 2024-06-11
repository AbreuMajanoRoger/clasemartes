package com.example.horosclase.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.R
import com.example.horosclase.horoscopoclass


class horosAdapter(val horosList:List<horoscopoclass>):RecyclerView.Adapter<horosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): horosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horoscopo, parent, false)
        return horosViewHolder(view)
    }

    override fun getItemCount(): Int = horosList.size


    override fun onBindViewHolder(holder: horosViewHolder, position: Int) {
        holder.render(horosList[position])
    }
}

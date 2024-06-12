package com.example.horosclase.adapter
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.horoscopoclass
import  android.widget.TextView
import com.example.horosclase.R

class horosViewHolder(view:View):RecyclerView.ViewHolder(view){

    val horosCopo = view.findViewById<TextView>(R.id.horosName)
    val imgHoroscopo = view.findViewById<ImageView>(R.id.imgHoroscopo)

    fun  render(horoscopoclass:horoscopoclass){
        horosCopo.setText(horoscopoclass.name)
        imgHoroscopo.setImageResource(horoscopoclass.photo)


    }
}






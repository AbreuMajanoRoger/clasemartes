package com.example.horosclase.adapter

import android.graphics.Color
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.R
import com.example.horosclase.data.horoscopoclass


class horosAdapter(private var dataSet:List<horoscopoclass>, private val onItemClickListener:(Int)->Unit):RecyclerView.Adapter<horosViewHolder>() {


    private var highlightText: String? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): horosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horoscopo, parent, false)

        return horosViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size



    override fun onBindViewHolder(holder:horosViewHolder, position: Int) {
        val horoscope = dataSet[position]
        holder.render(horoscope)
        if (highlightText != null) {
            holder.highlight(highlightText!!)
        }
        holder.itemView.setOnClickListener {
            onItemClickListener(position)
        }

        }

        fun updateData (newDataSet: List<horoscopoclass>, nothing: Nothing?) {
            updateData(newDataSet, null)
        }

        fun updateData(newDataSet: List<horoscopoclass>, highlight: String?) {
            this.highlightText  = highlight
            dataSet = newDataSet
            notifyDataSetChanged()
             }

        }

class horosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val horosName: TextView
    private val descTextView: TextView
    private val imgHoroscopo: ImageView

    init {
        horosName = view.findViewById(R.id.horosName)
        descTextView = view.findViewById(R.id.descTextView)
        imgHoroscopo = view.findViewById(R.id.imgHoroscopo)
    }

    fun render(horoscope: horoscopoclass) {
        horosName.setText(horoscope.name)
        descTextView.setText(horoscope.description)
        imgHoroscopo.setImageResource(horoscope.photo)
    }
    fun highlight(text: String) {
        try {
            val highlighted = horosName.text.toString().highlight(text)
            horosName.text = highlighted
        } catch (e: Exception) { }
        try {
            val highlighted = descTextView.text.toString().highlight(text)
            descTextView.text = highlighted
        } catch (e: Exception) { }
    }
}

fun String.highlight(text: String) : SpannableString {
    val str = SpannableString(this)
    val startIndex = str.indexOf(text, 0, true)
    str.setSpan(BackgroundColorSpan(Color.CYAN), startIndex, startIndex + text.length, 0)
    return str
}












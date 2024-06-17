package com.example.horosclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DetailActivity : AppCompatActivity() {

    companion object{

        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"

    }


     private lateinit var horoscope: horoscopoclass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val id= intent.getStringExtra(EXTRA_HOROSCOPE_ID)

        horoscope = horoscopoProvider.findById(id!!)!!
        findViewById<TextView>(R.id.textView).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageView).setImageResource(horoscope.photo)









        }





    }

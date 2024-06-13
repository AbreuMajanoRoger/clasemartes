package com.example.horosclase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.adapter.horosAdapter



class MainActivity : AppCompatActivity() {

   lateinit var horosList: List<horoscopoclass>

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horosList = horoscopoProvider.findAll()
        recyclerView = findViewById(R.id.horoscopoL)


        val adapter = horosAdapter(horosList){
            position->navigateToDetail(horosList[position])
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this)

    }

    fun navigateToDetail(horoscope:horoscopoclass){
        val intent: Intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID,horoscope.id)
        startActivity(intent)


    }




}
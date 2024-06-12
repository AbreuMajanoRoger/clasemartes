package com.example.horosclase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.adapter.horosAdapter
import com.example.horosclase.horoscopoProvider.Companion.horosList


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.horoscopoL)

        val adapter = horosAdapter(horoscopoProvider.horosList){
            position->navigateToDetail(horosList[position])
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this)

    }

    fun navigateToDetail(horoscope:horoscopoclass){
        val intent: Intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("HOROSCO_ID",horoscope.id)
        intent.putExtra("HOROSCO_NAME",horoscope.name)
        intent.putExtra("HOROSCO_LOGO",horoscope.photo)
        startActivity(intent)


    }




}
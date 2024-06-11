package com.example.horosclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.adapter.horosAdapter


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    recyclerView = findViewById(R.id.horoscopoL)
        val adapter = horosAdapter(horoscopoProvider.horosList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this)


    }
}
package com.example.horosclase.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horosclase.adapter.horosAdapter
import androidx.appcompat.widget.SearchView
import com.example.horosclase.R
import com.example.horosclase.data.horoscopoProvider
import com.example.horosclase.data.horoscopoclass


class MainActivity : AppCompatActivity() {

    lateinit var adapter: horosAdapter
    lateinit var horosList: List<horoscopoclass>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horosList = horoscopoProvider.findAll()
        recyclerView = findViewById(R.id.horoscopoL)


        adapter = horosAdapter(horosList){
                position->navigateToDetail(horosList[position])
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

    val searchViewItem = menu.findItem(R.id.menu_search)
    val searchView = searchViewItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    horosList = horoscopoProvider.findAll().filter { getString(it.name).contains(newText, true) ||
                                getString(it.description).contains(newText, true)


                }
                    adapter.updateData(horosList, newText)
                }
                return true
            }
        })

        return true
    }


    // today 17 jun: 9:40 fin

    fun navigateToDetail(horoscope: horoscopoclass){
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID,horoscope.id)
        startActivity(intent)


    }


}
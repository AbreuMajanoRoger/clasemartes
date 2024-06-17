package com.example.horosclase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.ImageView
import android.view.Menu
import android.view.MenuItem
import com.example.horosclase.R
import com.example.horosclase.data.horoscopoProvider
import com.example.horosclase.data.horoscopoclass
import com.example.horosclase.utils.SessionManager

class DetailActivity : AppCompatActivity() {

    companion object{

        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"

    }


  lateinit var horoscope: horoscopoclass
    var isFavorite = false

    lateinit var imgageView: ImageView
    lateinit var textView: TextView

    lateinit var favoriteMenuItem: MenuItem

    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        session = SessionManager(this)


        val id= intent.getStringExtra(EXTRA_HOROSCOPE_ID)

        horoscope = horoscopoProvider.findById(id!!)!!
        findViewById<TextView>(R.id.textView).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageView).setImageResource(horoscope.photo)



        }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.horoscope_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem ): Boolean {
        return when (item.itemId) {
            R.id.menu_favorite -> {
                Log.i("MENU", "He hecho click en el menu de favorito")
                true
            }
            R.id.menu_share -> {
                Log.i("MENU", "He hecho click en el menu de compartir")
                true
            }
            else -> super.onOptionsItemSelected(item)
             }
        }
    }

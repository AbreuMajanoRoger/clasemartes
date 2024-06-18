package com.example.horosclase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.ImageView
import android.view.Menu
import android.view.MenuItem
import com.example.horosclase.R
import com.example.horosclase.data.horoscopoProvider
import com.example.horosclase.data.horoscopoclass
import com.example.horosclase.utils.SessionManager

class DetailActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"

    }


    lateinit var horoscope: horoscopoclass
    var isFavorite = false


    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var favoriteMenuItem: MenuItem
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        session = SessionManager(this)


        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)!!

        horoscope = horoscopoProvider.findById(id)!!
        isFavorite = session.isFavorite(horoscope.id)

        findViewById<TextView>(R.id.textView).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageView).setImageResource(horoscope.photo)

        supportActionBar?.setTitle(horoscope.name)
        supportActionBar?.setSubtitle(horoscope.description)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.horoscope_menu, menu)
        favoriteMenuItem = menu.findItem(R.id.menu_favorite)
        return true
    }

    fun setFavoriteIcon() {
        if (isFavorite) {
            favoriteMenuItem.setIcon(android.R.drawable.star_big_on)
        } else {
            favoriteMenuItem.setIcon(android.R.drawable.btn_star)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.menu_favorite -> {
                if (isFavorite) {
                    session.setFavoriteHoroscope("")
                } else {
                    session.setFavoriteHoroscope(horoscope.id)
                }
                isFavorite = !isFavorite
                setFavoriteIcon()
                true
            }

            R.id.menu_share -> {
                val sendIntent = Intent()
                sendIntent.setAction(Intent.ACTION_SEND)
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                sendIntent.setType("text/plain")

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}

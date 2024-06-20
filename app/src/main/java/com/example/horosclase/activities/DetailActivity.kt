package com.example.horosclase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL
import android.widget.TextView
import android.widget.ImageView
import android.view.Menu
import android.view.MenuItem
import com.example.horosclase.R
import com.example.horosclase.data.horoscopoProvider
import com.example.horosclase.data.horoscopoclass
import com.example.horosclase.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.net.ssl.HttpsURLConnection

class DetailActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"

    }


    lateinit var horoscope: horoscopoclass
    var isFavorite = false

    lateinit var dailyHoroscopeTextView: TextView
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var favoriteMenuItem: MenuItem
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        session = SessionManager(this)


        val id: String = intent.getStringExtra(EXTRA_HOROSCOPE_ID)!!

        horoscope = horoscopoProvider.findById(id)!!
        isFavorite = session.isFavorite(horoscope.id)

        dailyHoroscopeTextView = findViewById(R.id.dailyHoroscopeTextView)
        findViewById<TextView>(R.id.textView).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageView).setImageResource(horoscope.photo)

        supportActionBar?.setTitle(horoscope.name)
        supportActionBar?.setSubtitle(horoscope.description)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getDailyHoroscope()
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

    fun getDailyHoroscope() {

        CoroutineScope(Dispatchers.IO).launch {
            try {

                val url = URL("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=${horoscope.id}&day=TODAY")
                val con = url.openConnection() as HttpsURLConnection
                con.requestMethod = "GET"
                val responseCode = con.responseCode
                Log.i("HTTP", "Response Code :: $responseCode")


                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    val bufferedReader = BufferedReader(InputStreamReader(con.inputStream))
                    var inputLine: String?
                    val response = StringBuffer()
                    while (bufferedReader.readLine().also { inputLine = it } != null) {
                        response.append(inputLine)
                    }
                    bufferedReader.close()

                    val json = JSONObject(response.toString())
                    val result =  json.getJSONObject("data").getString("horoscope_data")

                    Log.w("HTTP", "Response :: $result")

                    runOnUiThread {
                        dailyHoroscopeTextView.text = result
                    }

                } else { // Hubo un error
                    Log.w("HTTP", "Response :: Hubo un error")
                }
            } catch (e: Exception) {
                Log.e("HTTP", "Response Error :: ${e.stackTraceToString()}")
            }
        }
    }








}








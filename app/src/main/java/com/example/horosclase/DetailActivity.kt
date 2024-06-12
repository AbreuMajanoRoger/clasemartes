package com.example.horosclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val id = intent.getStringExtra("HOROSCO_ID")
        val name= intent.getIntExtra("HOROSCO_NAME", -1)
        val logo= intent.getIntExtra("HOROSCO_LOGO",-1)

        findViewById<TextView>(R.id.textView).setText(name)
        findViewById<ImageView>(R.id.imageView).setImageResource(logo)


    }
}
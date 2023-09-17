package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.net.URL

class AboutActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        findViewById<CardView>(R.id.rajkishorbgp).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val url =Uri.parse("https://www.linkedin.com/in/rajkishorbgp/")
            intent.data = url
            startActivity(intent)
        }
    }
}
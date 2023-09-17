package com.rajkishorbgp.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rajkishorbgp.quizapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = "QuizApp"

        binding.about.setOnClickListener {
            startActivity(Intent(this@MainActivity,AboutActivity::class.java))
        }
        binding.start.setOnClickListener {
            val text = binding.textPersonName.text
            if (text.isNotEmpty()) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("name",text.toString())
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@MainActivity, "Enter the name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
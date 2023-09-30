package com.rajkishorbgp.quizapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.rajkishorbgp.quizapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences and editor within onCreate
        pref = this.getSharedPreferences("UserDetails", 0)
        editor = pref.edit()

        val userName = pref.getString("userName", null)
        binding.textPersonName.text = userName?.let { Editable.Factory.getInstance().newEditable(it) }

        binding.about.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }

        binding.start.setOnClickListener {
            val text = binding.textPersonName.text
            if (text.isNotEmpty()) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("name", text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@MainActivity, "Enter the name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        editor.putString("userName", binding.textPersonName.text.toString())
        editor.apply()
    }
}

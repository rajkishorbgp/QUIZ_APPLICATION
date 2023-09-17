package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rajkishorbgp.quizapplication.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val score = intent.getIntExtra("correct",0)
        val wrong  =intent.getIntExtra("wrong",0)

        binding.currectTextView.text="Currect answers: $score"
        binding.wrongTextView.text="Wrong answers: $wrong"
        binding.finalTextView.text="Final Score: $score"

        binding.restartButton.setOnClickListener {
            startActivity(Intent(this@ScoreActivity,MainActivity::class.java))
            finish()
        }
    }
}
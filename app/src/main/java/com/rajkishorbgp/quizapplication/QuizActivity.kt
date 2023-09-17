package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.rajkishorbgp.quizapplication.databinding.ActivityQuizBinding


class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list: ArrayList<QuestionManager>
    private var count = 0
    private var score = 0
    private var wrong = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.personName.text = "Hello, ${intent.getStringExtra("name")}"

        list = ArrayList()

        // Question
        list.add(QuestionManager("Which method can be defined only once in a program?",
            "finalize method", "main method", "static method", "private method", "main method"))
        list.add(QuestionManager("Which keyword is used by method to refer to the current object that invoked it?",
            "import", "this", "catch", "abstract", "this"))
        list.add(QuestionManager("Which of these access specifiers can be used for an interface?",
            "public", "protected", "private", "All of the mentioned", "public"))
        list.add(QuestionManager("Which of the following is correct way of importing an entire package 'pkg'?",
            "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.", "import pkg.*"))
        list.add(QuestionManager("What is the return type of Constructors?",
            "int", "float", "void", "None of the mentioned", "None of the mentioned"))


        if (list.isNotEmpty()) {
            if (count == 0) {
                binding.question.text = list[0].question
                binding.optionA.text = list[0].optionA
                binding.optionB.text = list[0].optionB
                binding.optionC.text = list[0].optionC
                binding.optionD.text = list[0].optionD
                binding.questionCount.text = "${this.count + 1}."
            }
        }

        binding.nextQuestion.setOnClickListener {
            if (binding.optionsRadioGroup.checkedRadioButtonId != -1) {
                selectedOption()
                if (count >= list.size) {
                    val intent = Intent(applicationContext, ScoreActivity::class.java)
                    intent.putExtra("correct", score)
                    intent.putExtra("wrong", wrong)
                    startActivity(intent)
                    finish()
                } else {
                    // To clear the selection:
                    binding.optionsRadioGroup.clearCheck()
                    binding.questionCount.text = "${this.count + 1}."
                    binding.question.text = list[count].question
                    binding.optionA.text = list[count].optionA
                    binding.optionB.text = list[count].optionB
                    binding.optionC.text = list[count].optionC
                    binding.optionD.text = list[count].optionD
                }
            }else{
                Toast.makeText(this,"Select the option",Toast.LENGTH_SHORT).show()
            }
        }

        binding.quitButton.setOnClickListener {
            val intent = Intent(this@QuizActivity, ScoreActivity::class.java)
            intent.putExtra("correct",score)
            intent.putExtra("wrong",wrong)
            startActivity(intent)
            finish()
        }
    }

    private fun selectedOption() {
        val selectedId = binding.optionsRadioGroup.checkedRadioButtonId
        val genderradioButton = findViewById<RadioButton>(selectedId)
        countScore(genderradioButton.text.toString())
    }

    private fun countScore(i: CharSequence) {
        if (list[count].answer == i) {
            score++
            Toast.makeText(applicationContext,"correct",Toast.LENGTH_SHORT).show()
        }else{
            wrong++
            Toast.makeText(applicationContext,"wrong",Toast.LENGTH_SHORT).show()
        }
        binding.score.text = score.toString()
        count++
    }
}
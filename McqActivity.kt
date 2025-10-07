package com.medstar.medstarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.medstar.medstarapp.databinding.ActivityMcqBinding

class McqActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMcqBinding
    private var currentQuestion = 0
    private val questions = listOf(
        Question(
            "Which is a common cause of pneumonia in children?",
            listOf("Strep. pneumoniae", "E. coli", "H. pylori", "S. aureus"),
            0
        ),
        Question(
            "Best initial step in preeclampsia management?",
            listOf("Bed rest", "Magnesium sulfate", "Labetalol", "Hydralazine"),
            1
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMcqBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadQuestion()
    }

    private fun loadQuestion() {
        val q = questions[currentQuestion]
        binding.txtQuestion.text = q.text
        binding.btnA.text = q.options[0]
        binding.btnB.text = q.options[1]
        binding.btnC.text = q.options[2]
        binding.btnD.text = q.options[3]

        val buttons = listOf(binding.btnA, binding.btnB, binding.btnC, binding.btnD)
        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                if (index == q.answerIndex) {
                    Toast.makeText(this, "✅ Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "❌ Wrong!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

data class Question(val text: String, val options: List<String>, val answerIndex: Int)

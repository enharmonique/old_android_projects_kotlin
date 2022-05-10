package com.example.biggernumberapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

//inheritence
class MainActivity : AppCompatActivity() {
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickRandomNumbers()
    }

    fun leftButtonClick(View: View) {
        checkAnswer(isLeft = true)
    }

    fun rightButtonClick(View: View) {
        checkAnswer(isLeft = false)
    }

    private fun checkAnswer(isLeft: Boolean) {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)

        val leftNum = leftButton.text.toString().toInt()
        val rightNum = rightButton.text.toString().toInt()

        val isAnswerCorrect = if (isLeft) leftNum > rightNum else leftNum < rightNum
        
        val toastMessage: String
        val backgroundColor: Int

        if (points == 10) {
            toastMessage = "YOU WIN!"
            backgroundColor = Color.YELLOW
            points = 0
        }
        else
        {
            if (isAnswerCorrect) {
                toastMessage = "Correct!"
                backgroundColor = Color.GREEN
                points++
            } else {
                toastMessage = "Wrong"
                backgroundColor = Color.RED
                points--
            }
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        val backgroundView = findViewById<View>(R.id.background)

        backgroundView.setBackgroundColor(backgroundColor)
        findViewById<TextView>(R.id.points).text = "Points: $points"
        pickRandomNumbers()
    }

    private fun pickRandomNumbers() {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)

        val r = Random()
        val num1 = r.nextInt(100)
        var num2 = num1

        while (num1 == num2) {
            num2 = r.nextInt(100)
        }

        leftButton.text = "$num1"
        rightButton.text = "$num2"
    }
}
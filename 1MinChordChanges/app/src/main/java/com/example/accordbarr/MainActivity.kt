package com.example.accordbarr

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val chords = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun countDown(View: View) {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                timer.setText("done!").toString()
            }
        }.start()
        chords.shuffled()
        chord1.setText(chords.random()).toString()
        chords.shuffled()
        chord2.setText(chords.random()).toString()
    }

}
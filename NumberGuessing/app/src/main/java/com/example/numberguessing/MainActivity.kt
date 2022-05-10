package com.example.numberguessing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    var randomNumber = Random().nextInt(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkNumber(View: View){
        val text = findViewById<TextView>(R.id.num)
        var num = text.text.toString().toInt()
        val toastMessage: String

        if(num < randomNumber){
            toastMessage = "Tul kicsi"
        }
        else if(num > randomNumber){
            toastMessage = "Tul nagy"
        }
        else{
            toastMessage = "Helyes!"
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }
    fun generateNewRandomNum(View: View){
        randomNumber = Random().nextInt(10)
    }
}



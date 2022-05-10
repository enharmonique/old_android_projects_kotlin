package com.example.flowers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*lambda function
        flowerList.setOnItemClickListener { _, _, _, _ ->
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        }
         */
        //list, item, index, id
        flowerList.setOnItemClickListener { _, _, index, _ ->
            val id = when(index){
                0 -> R.drawable.iris
                1 -> R.drawable.rose
                2 -> R.drawable.lily
                else -> R.drawable.orchid
            }
            flower.setImageResource(id)
        }
    }

    fun radioBtnClick(view: View){
        /*
        //if (view == radioButtonIris){
            //if (view.id == R.id.radioButtonIris){
            //flower.setImageResource(R.drawable.iris)}
        //OR
        val id = when(view){
            radioButtonIris -> R.drawable.iris
            radioButtonRose -> R.drawable.rose
            radioButtonLily -> R.drawable.lily
            else -> R.drawable.orchid
            }
            flower.setImageResource(id)
         */
        when (view) {
            radioButtonIris -> flower.setImageResource(R.drawable.iris)
            radioButtonRose -> flower.setImageResource(R.drawable.rose)
            radioButtonLily -> flower.setImageResource(R.drawable.lily)
            radioButtonOrchid -> flower.setImageResource(R.drawable.orchid)

        }

    }
}
package com.example.dictionary

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var wordToDefn = HashMap<String, String>()
    private val defns = ArrayList<String>()
    private val words = ArrayList<String>()
    //running too early
    private lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readDictionaryFile()
        setupList()

        definitions_list.setOnItemClickListener{ _, view, index, _ ->

            val toastMessage: String
            val backgroundColor: Int
            if (defns[index] == wordToDefn[the_word.text]){
                //defns.removeAt(index)
                toastMessage = "Correct!"
                setupList()
                adapter.notifyDataSetChanged()
            }
            else
            {
                toastMessage = "Wrong"
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    view.setBackgroundColor(Color.RED)
                }
            }
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun readDictionaryFile(){
        val reader = Scanner(resources.openRawResource(R.raw.grewords))
        while (reader.hasNextLine()){
            val line = reader.nextLine()
            Log.d("idk","the line is: $line")
            val pieces = line.split(" ")
            if(pieces.size >= 2) {
                words.add(pieces[0])
                wordToDefn[pieces[0]] = pieces[1]
            }
        }
    }

    private fun setupList(){
        //pick a random word
        val rand = Random()
        val index = rand.nextInt(words.size)
        val word = words[index]
        the_word.text = word

        defns.clear()
        defns.add(wordToDefn[word]!!)

        words.shuffle()
        for (otherWord in words.subList(0, 4)){
            if(otherWord == word || defns.size == 5) {
                continue
            }
            defns.add(wordToDefn[otherWord]!!)
        }
        defns.shuffle()

        adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, defns)

        definitions_list.adapter = adapter
    }
}
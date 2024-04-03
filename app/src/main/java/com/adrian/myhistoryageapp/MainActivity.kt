package com.adrian.myhistoryageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    private lateinit var searchbutton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        searchbutton = findViewById(R.id.searchButton)
        clearbutton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)

        searchbutton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..100) {
                val famouspersonName = when (age) {
                    95 -> "Nelson Mandela"
                    84 -> "Isaac Newton"
                    76 -> "Albert Einstein"
                    60 -> "Diego Maradona"
                    80 -> "Donatello"
                    99 -> "Leonardo Davinci"
                    66 -> "Marie Curie"
                    52 -> "William Shakespeare"
                    36 -> "Bob Marley"
                    100 -> "Charlie Trippi"

                    else -> null
                }

                val message = if (famouspersonName != null) "You are the same age as $famouspersonName,$famouspersonName was a historic person"
                else "No Famous Person found within the entered age."
                resultTextView.text = message
            } else {
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 100"
            }
        }
        clearbutton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }
}

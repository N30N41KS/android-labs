package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Элементы Лабораторной №2
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        textViewResult.text = ""

        buttonSend.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                textViewResult.text = "Привет, $name!"
            } else {
                textViewResult.text = ""
            }
        }

        // Элементы Лабораторной №3
        val input1 = findViewById<EditText>(R.id.input1)
        val buttonNext = findViewById<Button>(R.id.next)

        buttonNext.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("text", input1.text.toString())
            startActivity(intent)
        }
    }
}
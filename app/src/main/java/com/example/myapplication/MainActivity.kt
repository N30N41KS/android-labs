package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        // Изначально скрываем/очищаем поле вывода
        textViewResult.text = ""

        buttonSend.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                textViewResult.text = "Привет, $name!"
            } else {
                textViewResult.text = ""
            }
        }
    }
}
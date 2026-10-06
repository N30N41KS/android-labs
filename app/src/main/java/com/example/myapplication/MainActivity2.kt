package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val shown = findViewById<TextView>(R.id.shown)
        val backButton = findViewById<Button>(R.id.back)

        shown.text = intent.getStringExtra("text")

        backButton.setOnClickListener {
            finish()
        }
    }
}
package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Lab4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4)

        val backBtn = findViewById<Button>(R.id.backBtn4)
        backBtn.setOnClickListener {
            finish()
        }
    }
}

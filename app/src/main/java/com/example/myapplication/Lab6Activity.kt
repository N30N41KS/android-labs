package com.example.myapplication

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Lab6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6)

        val animatedImage = findViewById<ImageView>(R.id.animatedImage)
        val btnRotate = findViewById<Button>(R.id.btnRotate)
        val btnScale = findViewById<Button>(R.id.btnScale)
        val backBtn = findViewById<Button>(R.id.backBtn6)

        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)

        btnRotate.setOnClickListener {
            animatedImage.startAnimation(rotateAnimation)
        }

        btnScale.setOnClickListener {
            animatedImage.startAnimation(scaleAnimation)
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}

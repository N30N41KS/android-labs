package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Lab5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val backButton = findViewById<Button>(R.id.backBtn5)

        // Тестовый набор данных со встроенными системными иконками Android
        val dataList = listOf(
            ListItem("Android Studio", "Среда разработки мобильных приложений", android.R.drawable.ic_menu_manage),
            ListItem("Kotlin", "Основной язык разработки под Android", android.R.drawable.ic_menu_compass),
            ListItem("RecyclerView", "Гибкий компонент для отображения списков", android.R.drawable.ic_menu_agenda),
            ListItem("Activity & Intent", "Компоненты навигации и экранов", android.R.drawable.ic_menu_directions),
            ListItem("Google Pixel 9a", "Тестовое устройство для отладки", android.R.drawable.ic_menu_call)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(dataList)

        backButton.setOnClickListener {
            finish()
        }
    }
}

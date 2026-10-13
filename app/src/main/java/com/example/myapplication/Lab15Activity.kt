package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Lab15Activity : AppCompatActivity() {

    private lateinit var helper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        helper = DbHelper(this)

        val input = findViewById<EditText>(R.id.input)
        val out = findViewById<TextView>(R.id.out)

        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        input.setText(prefs.getString("last", ""))

        findViewById<Button>(R.id.btn1).setOnClickListener {
            val text = input.text.toString()
            prefs.edit().putString("last", text).apply()

            val cv = ContentValues()
            cv.put("text", text)
            helper.writableDatabase.insert("notes", null, cv)

            input.setText("")
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            val sb = StringBuilder()
            val c = helper.readableDatabase.query("notes", null, null, null, null, null, null)
            while (c.moveToNext()) {
                val idIndex = c.getColumnIndex("_id")
                val textIndex = c.getColumnIndex("text")
                val id = if (idIndex != -1) c.getInt(idIndex) else 0
                val text = if (textIndex != -1) c.getString(textIndex) else ""
                sb.append(id).append(". ").append(text).append("\n")
            }
            c.close()
            out.text = sb.toString()
        }
    }
}

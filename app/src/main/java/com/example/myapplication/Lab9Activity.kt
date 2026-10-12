package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Lab9Activity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var hidden: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab9)

        input = findViewById(R.id.input)
        hidden = findViewById(R.id.hidden)
        val backBtn = findViewById<Button>(R.id.backBtn9)

        // Регистрация контекстного меню для надписи hidden
        registerForContextMenu(hidden)

        backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_show_text -> {
                item.isChecked = !item.isChecked
                if (item.isChecked) {
                    hidden.visibility = View.VISIBLE
                } else {
                    hidden.visibility = View.GONE
                }
                true
            }
            R.id.action_clear -> {
                input.text.clear()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_red -> {
                hidden.setTextColor(Color.RED)
                true
            }
            R.id.action_black -> {
                hidden.setTextColor(Color.BLACK)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}

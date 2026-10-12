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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Lab9Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab9)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left + 48, systemBars.top + 48, systemBars.right + 48, systemBars.bottom + 48)
            insets
        }

        registerForContextMenu(findViewById(R.id.hidden))

        val backBtn = findViewById<Button>(R.id.backBtn9)
        backBtn?.setOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_show) {
            item.isChecked = !item.isChecked
            findViewById<View>(R.id.hidden).visibility =
                if (item.isChecked) View.VISIBLE else View.INVISIBLE
            return true
        } else if (item.itemId == R.id.menu_clear) {
            findViewById<EditText>(R.id.input).setText("")
            return true
        }
        return super.onOptionsItemSelected(item)
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
        val t = findViewById<TextView>(R.id.hidden)
        if (item.itemId == R.id.ctx_red) {
            t.setTextColor(Color.RED)
            return true
        } else if (item.itemId == R.id.ctx_black) {
            t.setTextColor(Color.BLACK)
            return true
        }
        return super.onContextItemSelected(item)
    }
}

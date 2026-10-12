package com.example.myapplication

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MyWidgetConfigureActivity : AppCompatActivity() {

    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    private lateinit var urlEdit: EditText
    private lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResult(RESULT_CANCELED)
        setContentView(R.layout.my_widget_configure)

        urlEdit = findViewById(R.id.url_edit)
        saveBtn = findViewById(R.id.save_btn)

        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }

        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }

        saveBtn.setOnClickListener {
            val context = this@MyWidgetConfigureActivity
            var url = urlEdit.text.toString().trim()
            if (url.isEmpty()) {
                url = "https://www.google.com"
            } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }

            saveUrlPref(context, appWidgetId, url)

            val appWidgetManager = AppWidgetManager.getInstance(context)
            MyWidget.updateAppWidget(context, appWidgetManager, appWidgetId)

            val resultValue = Intent()
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            setResult(RESULT_OK, resultValue)
            finish()
        }
    }

    companion object {
        private const val PREFS_NAME = "com.example.myapplication.MyWidget"
        private const val PREF_PREFIX_KEY = "appwidget_"

        fun saveUrlPref(context: Context, appWidgetId: Int, url: String) {
            val prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit()
            prefs.putString(PREF_PREFIX_KEY + appWidgetId, url)
            prefs.apply()
        }

        fun loadUrlPref(context: Context, appWidgetId: Int): String {
            val prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
            val urlValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, null)
            return urlValue ?: "https://www.google.com"
        }

        fun deleteUrlPref(context: Context, appWidgetId: Int) {
            val prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit()
            prefs.remove(PREF_PREFIX_KEY + appWidgetId)
            prefs.apply()
        }
    }
}

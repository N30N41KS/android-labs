package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Lab7Activity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab7)

        val webView = findViewById<WebView>(R.id.mapWebView)
        val backBtn = findViewById<Button>(R.id.backBtn7)

        // Настройка WebView для загрузки OpenStreetMap прямо внутри приложения
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl("https://www.openstreetmap.org")

        backBtn.setOnClickListener {
            finish()
        }
    }
}

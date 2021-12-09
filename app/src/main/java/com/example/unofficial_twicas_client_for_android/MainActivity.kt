package com.example.unofficial_twicas_client_for_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val accessToken: String? = intent.getStringExtra("ACCESS_TOKEN")
        Toast.makeText(this, accessToken, Toast.LENGTH_SHORT).show()
    }
}
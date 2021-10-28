package com.example.serviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun serviceButton(view: android.view.View) {
        var intent : Intent = Intent(this, StopwatchService::class.java)
        startService(intent)
    }
}
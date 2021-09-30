package com.example.exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(null, "CREATED")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Test", "STARTED")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Test", "RESUMED")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Test", "PAUSED")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Test", "STOPPED")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Test", "DESTROYED")
    }
}
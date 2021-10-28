package com.example.gesturedetectionexample

import android.gesture.Gesture
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity() {

    private lateinit var  myDetector : GestureDetectorCompat

    private lateinit var gestureText : TextView
    private lateinit var gestureColor : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gestureText = findViewById(R.id.gesture_display)
        gestureColor = findViewById(R.id.gesture_color)

        myDetector = GestureDetectorCompat(this, MyGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        myDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }


    private inner class MyGestureListener : GestureDetector.SimpleOnGestureListener(){

        override fun onDown(event: MotionEvent?) : Boolean{
            Log.i("Gesture detected", "Down Detected")
            return true
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            Log.i("Gesture detected", "Double Tap Detected")
            gestureText.text = "Double Tap Detected"
            gestureColor.setBackgroundColor(Color.GREEN)
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            Log.i("Gesture detected", "Fling Detected")
            gestureText.text = "Fling Detected"
            gestureColor.setBackgroundColor(Color.BLUE)
            return true
        }

    }
}
package com.example.threadingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    lateinit var printer : PrintThread

    var iterations : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printer = PrintThread()

    }

    inner class PrintThread : Thread() {
        override fun run() {
            super.run()
            while(true){
                iterations += 1
                Log.i("ThreadingTest", "GME stock price = " + iterations.toString() + "$")
                sleep(1000)
            }
        }
    }

    fun runThread(view : View){
        printer.run()
    }
}
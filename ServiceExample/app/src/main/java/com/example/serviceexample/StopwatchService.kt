package com.example.serviceexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class StopwatchService : Service() {
    var seconds : Int = 0
    var counter : CounterThread = CounterThread()
    lateinit var builder : NotificationCompat.Builder
    override fun onBind(p0: Intent?): IBinder? {
        // Required but not need so return null, unless bounded service :)
        return null
    }

    inner class CounterThread : Thread(){
        override fun run() {
            super.run()
            while (true){
                seconds+=1
                Log.i("counter", seconds.toString())
                sleep(1000)
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        counter.start()
        return super.onStartCommand(intent, flags, startId)
    }

}
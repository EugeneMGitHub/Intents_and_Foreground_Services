package com.example.intents_foregroundservicemytest.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.intents_foregroundservicemytest.Const.Const
import com.example.intents_foregroundservicemytest.Const.Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE
import com.example.intents_foregroundservicemytest.Const.Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE_ID
import com.example.intents_foregroundservicemytest.R

class TestForegroundService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
           Actions.START.toString() -> {
                start()
           }
            Actions.STOP.toString() -> {stopSelf()}
        }

        return super.onStartCommand(intent, flags, startId)
    }





    private fun start(){

        val notification = NotificationCompat.Builder(this, CHANEL_FOR_TEST_FOREGROUND_SERVICE)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("This is notification for TESTforeground service")
            .setContentText("This is the message of the TESTservice")
            .build()

        startForeground(CHANEL_FOR_TEST_FOREGROUND_SERVICE_ID, notification)
    }








    enum class Actions {
        START, STOP
    }


}
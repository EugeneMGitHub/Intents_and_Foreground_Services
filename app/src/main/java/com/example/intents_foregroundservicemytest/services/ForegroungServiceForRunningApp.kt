package com.example.intents_foregroundservicemytest.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.intents_foregroundservicemytest.Const.Const.CHANEL_FOR_FOREGROUND_SERVICE
import com.example.intents_foregroundservicemytest.Const.Const.CHANEL_FOR_FOREGROUND_SERVICE_ID
import com.example.intents_foregroundservicemytest.R

class ForegroungServiceForRunningApp : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
            Actions.START.toString() -> {start()}
            Actions.STOP.toString() -> {stopSelf()}
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){
        val notification = NotificationCompat.Builder(this, CHANEL_FOR_FOREGROUND_SERVICE)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("This is notification for foreground service")
            .setContentText("This is the message of the service")
            .build()

        startForeground(CHANEL_FOR_FOREGROUND_SERVICE_ID, notification)
    }

    enum class Actions {
        START, STOP
    }



}
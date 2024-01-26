package com.example.intents_foregroundservicemytest

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.intents_foregroundservicemytest.Const.Const.CHANEL_FOR_FOREGROUND_SERVICE
import com.example.intents_foregroundservicemytest.Const.Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE

class AppInstance : Application(){

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CHANEL_FOR_FOREGROUND_SERVICE,
                "Running Notification service",
                NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)

        }



            // Для другого сервиса
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
               createNotificationChannel(CHANEL_FOR_TEST_FOREGROUND_SERVICE, CHANEL_FOR_TEST_FOREGROUND_SERVICE)
             }


    }







    // I found this code here https://stackoverflow.com/questions/47531742/startforeground-fail-after-upgrade-to-android-8-1
    // it helps if you want to create many services
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val channel = NotificationChannel(channelId,
            channelName, NotificationManager.IMPORTANCE_HIGH)
        //    channel.lightColor = Color.BLUE
        //    channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        return channelId
    }

}



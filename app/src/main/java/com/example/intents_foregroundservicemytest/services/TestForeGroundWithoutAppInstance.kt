package com.example.intents_foregroundservicemytest.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.intents_foregroundservicemytest.Const.Const
import com.example.intents_foregroundservicemytest.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestForeGroundWithoutAppInstance : Service() {


    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    val channelId = Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE_WITHOUT_APP_INSTANCE
    val channelName = Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE_WITHOUT_APP_INSTANCE
    val foregroundServiceId = Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE_WITHOUT_APP_INSTANCE_ID
    val notificationTitle = "This is notification title for TESTforeground service without app instance"

    val countingStartedText = "Counting has started"
    val countingSoppedText = "Counting has stopped"


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
            Actions.START.toString() -> {
                val channelId = createChannel(channelId = this.channelId, channelName = this.channelName)
                startCount()
            }
            Actions.STOP.toString() -> {stopSelf()}

        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun startCount(){

        scope.launch {
            startForegroundWithNotification(channelId = channelId, notificationTitle = notificationTitle, notificationText = countingStartedText)
            for (i in 0 until 10 ){
                Log.d("NormalService", "Service:: Count is $i")
                delay(1000L)
                if (i == 9){
                    startForegroundWithNotification(channelId = channelId, notificationTitle = notificationTitle, notificationText = countingSoppedText)
                    delay(5000L)
                    stopSelf()
                }
            }
        }
    }




    private fun startForegroundWithNotification(channelId: String, notificationTitle: String, notificationText:String) {
        val notification = createNotification(channelId = channelId, notificationTitle = notificationTitle, notificationText = notificationText )
        startForeground(foregroundServiceId, notification)
    }

    private fun createNotification(channelId: String, notificationTitle: String, notificationText: String): Notification{
        val notificationBuilder = NotificationCompat.Builder(this, channelId )
        val notification = notificationBuilder
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(notificationTitle)
            .setContentText(notificationText)
            .build()

        return notification
    }


    private fun createChannel(channelId: String, channelName: String) : String{
        val channelId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(
                Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE_WITHOUT_APP_INSTANCE,
                Const.CHANEL_FOR_TEST_FOREGROUND_SERVICE_WITHOUT_APP_INSTANCE
            )
        } else {
            // If earlier version channel ID is not used
            // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
            ""
        }

        return channelId
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        return channelId
    }

    enum class Actions {
        START, STOP
    }


}
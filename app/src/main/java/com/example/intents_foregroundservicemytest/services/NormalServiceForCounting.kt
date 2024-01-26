package com.example.intents_foregroundservicemytest.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NormalServiceForCounting : Service() {

    // https://stackoverflow.com/questions/63405673/how-to-call-suspend-function-from-service-android
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Toast.makeText(this, "Normal service has been started", Toast.LENGTH_LONG).show()

        startCount()

        return super.onStartCommand(intent, flags, startId)
    }



    private  fun startCount(){

        scope.launch {
            for (i in 0 until 10 ){
                Log.d("NormalService", "Service:: Count is $i")
                delay(1000L)
                if (i == 9){
                    stopSelf()
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "Normal service has been killed", Toast.LENGTH_LONG).show()

        // тут мы убиваем коррутин который создали ранее, таким образом гарантируется,
        // что циклы жизни коррутина и сервиса совпадут
        job.cancel()
    }

}





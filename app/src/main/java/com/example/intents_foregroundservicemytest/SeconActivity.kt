package com.example.intents_foregroundservicemytest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.intents_foregroundservicemytest.screens.SecondScreen
import com.example.intents_foregroundservicemytest.ui.theme.Intents_ForeGroundServiceMyTestTheme

class SeconActivity(): ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Intents_ForeGroundServiceMyTestTheme {
                SecondScreen()

//                val intent = Intent(applicationContext, MainActivity::class.java).also {
//                    this.startActivity(it)
//                }

            }
        }
    }
}
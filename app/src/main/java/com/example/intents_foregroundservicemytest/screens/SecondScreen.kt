package com.example.intents_foregroundservicemytest.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.intents_foregroundservicemytest.MainActivity
import com.example.intents_foregroundservicemytest.SeconActivity

@Composable
fun SecondScreen(
//    context : Context
) {
    val context = LocalContext.current
    val activity = if (context is Activity) context else null

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(
            onClick = {
                Intent(context, MainActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter)

        ) {
            Text(
                text = "To first activity",
                textAlign = TextAlign.Center,
            )
        }


        Button(
            onClick = {
             activity?.finish()
            },
            modifier = Modifier.align(Alignment.Center)

        ) {
            Text(
                text = "Stop second activity",
                textAlign = TextAlign.Center,
            )
        }


    }


}
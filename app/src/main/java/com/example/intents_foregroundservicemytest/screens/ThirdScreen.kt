package com.example.intents_foregroundservicemytest.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.intents_foregroundservicemytest.SeconActivity

@Composable
fun ThirdScreen (){


    val context = LocalContext.current
    val activity = if (context is Activity) context else null

    Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                Intent(context, SeconActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)

        ) {
            Text(
                text = "To second activity",
                textAlign = TextAlign.Center,
            )

        }


        Button(
            onClick = {
                Intent(context, SeconActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)

        ) {
            Text(
                text = "To third activity with extra",
                textAlign = TextAlign.Center,
            )

        }


    }


}
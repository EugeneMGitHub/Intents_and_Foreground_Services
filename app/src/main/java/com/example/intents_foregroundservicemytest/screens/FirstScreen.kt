package com.example.intents_foregroundservicemytest.screens

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier



import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.intents_foregroundservicemytest.SeconActivity
import com.example.intents_foregroundservicemytest.ThirdActivity
import com.example.intents_foregroundservicemytest.ThirdActivity.Companion.ARG_TEXT

import com.example.intents_foregroundservicemytest.services.NormalServiceForCounting
import com.example.intents_foregroundservicemytest.services.ForegroungServiceForRunningApp
import com.example.intents_foregroundservicemytest.services.TestForeGroundWithoutAppInstance
import com.example.intents_foregroundservicemytest.services.TestForegroundService

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FirstScreen(
//    context : Context
) {
    val context = LocalContext.current
    val activity = if (context is Activity) context else null

    val goToSecondActivityIntent = Intent(context, SeconActivity::class.java)

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
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "To second activity",
                textAlign = TextAlign.Center,
            )

        }


        Button(
            onClick = {
        //              val intent = ThirdActivity.newIntent(context, "THIS IS passed text")
        //                context.startActivity(intent)

                      Intent(context, ThirdActivity::class.java)
                          .putExtra(ARG_TEXT, "Cat and Dog")
                          .also {
                          context.startActivity(it)
                      }

            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "To third activity with extra",
                textAlign = TextAlign.Center,
            )

        }






        val serviceiIntent = Intent(context, ForegroungServiceForRunningApp::class.java)

        Button(
            onClick = {
                val serviceIntent = Intent(context, ForegroungServiceForRunningApp::class.java)
                serviceIntent.also {
                    it.action = ForegroungServiceForRunningApp.Actions.START.toString()
                    activity?.startService(it)
                }
            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "Start Foreground Service",
                textAlign = TextAlign.Center,
            )

        }

        Button(
            onClick = {
                val serviceIntent = Intent(context, ForegroungServiceForRunningApp::class.java)
                serviceIntent.also {
                    it.action = ForegroungServiceForRunningApp.Actions.STOP.toString()
                    context.startService(it)
                }
            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "Stop Foreground Service",
                textAlign = TextAlign.Center,
            )

        }














        Button(
            onClick = {
//               Intent(context, CountService::class.java).also {
//                    activity?.startService(it)
//                }

                activity?.startService(Intent(context, NormalServiceForCounting::class.java))
            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "Start just a service",
                textAlign = TextAlign.Center,
            )

        }


        Button(
            onClick = {
                activity?.stopService(Intent(context, NormalServiceForCounting::class.java))
            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "Stop manually just a service",
                textAlign = TextAlign.Center,
            )

        }


        Spacer(Modifier.height(30.dp))


        Button(
            onClick = {
                val serviceIntent = Intent(context, TestForegroundService::class.java)
                serviceIntent.also {
                    it.action = TestForegroundService.Actions.START.toString()
                    activity?.startService(it)
                }
            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "Start TestForeground Service",
                textAlign = TextAlign.Center,
            )

        }


        Spacer(Modifier.height(30.dp))


//        Button(
//            onClick = {
//               Intent(context, TestForeGroundWithoutAppInstance::class.java).also {
//                   it.action = TestForeGroundWithoutAppInstance.Actions.START.toString()
//                   context.startService(it)
//               }
//            },
//            modifier = Modifier.align(CenterHorizontally)
//
//        ) {
//            Text(
//                text = "Start TestForeground Service without app Instance",
//                textAlign = TextAlign.Center,
//            )
//
//        }




        Button(
            onClick = {
                Intent(context, TestForeGroundWithoutAppInstance::class.java).also {
                    it.action = TestForeGroundWithoutAppInstance.Actions.START.toString()
                    context.startForegroundService(it)
                }
            },
            modifier = Modifier.align(CenterHorizontally)

        ) {
            Text(
                text = "Start TestForeground Service without app Instance",
                textAlign = TextAlign.Center,
            )

        }



    }


}
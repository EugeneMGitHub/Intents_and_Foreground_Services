package com.example.intents_foregroundservicemytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.intents_foregroundservicemytest.screens.SecondScreen
import com.example.intents_foregroundservicemytest.ui.theme.Intents_ForeGroundServiceMyTestTheme

class ThirdActivity(): ComponentActivity(){

    companion object{
        const val ARG_TEXT = "ARG_TEXT"

        fun newIntent(context: Context, text : String) =
         Intent(context, ThirdActivity::class.java).apply {
             putExtra(ARG_TEXT, text)
         }


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text  =intent?.extras?.getString(ARG_TEXT) ?: ""

        setContent {
            Intents_ForeGroundServiceMyTestTheme {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "passed text is $text",
                        modifier = Modifier.align(CenterHorizontally)
                        )
                    Button(
                        onClick = {
                            Intent(applicationContext, MainActivity::class.java).also {
                                startActivity(it)
                            }
                        },
                        modifier = Modifier.align(CenterHorizontally)) {
                        Text(text = "Go to first Activity")

                    }
                }




            }
        }
    }
}
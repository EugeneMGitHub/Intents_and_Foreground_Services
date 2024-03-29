package com.example.intents_foregroundservicemytest

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.intents_foregroundservicemytest.screens.FirstScreen
import com.example.intents_foregroundservicemytest.ui.theme.Intents_ForeGroundServiceMyTestTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }



        setContent {
            Intents_ForeGroundServiceMyTestTheme {
                // A surface container using the 'background' color from the theme

//                Intent(applicationContext,SeconActivity::class.java).also { intent ->
//                                this.startActivity(intent)
//                }
//                or
                //                Intent(applicationContext,SeconActivity::class.java).also { intent ->
//                                startActivity(intent)
//                }





                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    FirstScreen()



                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Intents_ForeGroundServiceMyTestTheme {
        Greeting("Android")
    }
}
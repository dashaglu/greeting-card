package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.ironsource.mediationsdk.IronSource
import com.ironsource.mediationsdk.IronSource.AD_UNIT
import com.example.greetingcard.listeners.MyLevelPlayInterstitialListener
import com.example.greetingcard.Constants
import com.ironsource.mediationsdk.integration.IntegrationHelper

class MainActivity : ComponentActivity() {

    private val mLevelPlayInterstitialListener = MyLevelPlayInterstitialListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Darya")
                }
            }
        }

        IronSource.init(this, Constants.IS_SDK_APP_KEY, AD_UNIT.INTERSTITIAL)
        // Validate IronSource integration
        IntegrationHelper.validateIntegration(this)
    }

    override fun onResume() {
        super.onResume()
        IronSource.onResume(this)

        loadInterstitial()
    }

    override fun onPause() {
        super.onPause()
        IronSource.onPause(this)
    }

    private fun loadInterstitial() {
        IronSource.loadInterstitial();
        IronSource.setLevelPlayInterstitialListener(mLevelPlayInterstitialListener);
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Magenta) {
        Text(
            text = "Hello, my name is $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        Greeting("Darya")
    }
}
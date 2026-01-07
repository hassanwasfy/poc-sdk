package com.hwasfy.pocsdk.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hwasfy.pocsdk.network.WeatherSdk

@Composable
fun WeatherScreen() {
    val getData = remember { mutableStateOf(false) }
    val sdk = remember { WeatherSdk() }
    val data = produceState("Not fetched yet...", getData.value) {
        if (getData.value) {
            value = sdk.getWeatherText()
            getData.value = false
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = data.value)
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { getData.value = true }
            ) {
                Text(text = "Fetch")
            }
        }
    }
}

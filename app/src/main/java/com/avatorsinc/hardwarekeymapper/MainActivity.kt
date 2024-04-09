package com.avatorsinc.hardwarekeymapper

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avatorsinc.hardwarekeymapper.ui.theme.HardwareKeyMapperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HardwareKeyMapperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingWithAccessibilityButton("Android")
                }
            }
        }
    }
}

@Composable
fun GreetingWithAccessibilityButton(name: String) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Welcome to KeyMapper, $name!",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(onClick = {
            Toast.makeText(context, "Have a nice day!", Toast.LENGTH_SHORT).show()
        }) {
            Text("Click Me")
        }
        // Add a new button to open accessibility settings
        Button(onClick = {
            context.startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }) {
            Text("Enable Accessibility Service")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HardwareKeyMapperTheme {
        GreetingWithAccessibilityButton("Android")
    }
}

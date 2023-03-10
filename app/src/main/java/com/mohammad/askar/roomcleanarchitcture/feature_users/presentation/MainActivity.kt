package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.navigation.NavHost
import com.mohammad.askar.roomcleanarchitcture.ui.theme.RoomCleanArchitctureTheme
import com.mohammad.askar.roomcleanarchitcture.ui.theme.gray
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomCleanArchitctureTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.background(gray)) {
                    NavHost()
                }

            }
        }
    }
}

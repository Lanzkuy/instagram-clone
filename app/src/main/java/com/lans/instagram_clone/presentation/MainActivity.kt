package com.lans.instagram_clone.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.lans.instagram_clone.presentation.navigation.Navigation
import com.lans.instagram_clone.presentation.navigation.Route
import com.lans.instagram_clone.presentation.theme.InstagramCloneTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition { viewModel.splashState }

        observeAuthentication()
    }

    private fun observeAuthentication() {
        lifecycleScope.launch {
            viewModel.isAuthenticated.collect { status ->
                status?.let {
                    val startDestination = if (status) Route.HomeScreen else Route.LoginScreen
                    setContent {
                        InstagramCloneTheme(dynamicColor = false) {
                            InstagramCloneApp(startDestination = startDestination)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InstagramCloneApp(
    startDestination: Route,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        Navigation(startDestination = startDestination)
    }
}
package com.santimattius.android.skeleton.features.games.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import coil.annotation.ExperimentalCoilApi
import com.santimattius.android.skeleton.core.ui.GameScaffold
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalCoilApi
@ExperimentalLifecycleComposeApi
@AndroidEntryPoint
class GamesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScaffold {
                GamesRoute {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        this.data = Uri.parse("app://game/${it.id}")
                    }
                    startActivity(intent)
                }
            }
        }
    }
}

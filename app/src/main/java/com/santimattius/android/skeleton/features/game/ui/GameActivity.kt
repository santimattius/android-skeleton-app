package com.santimattius.android.skeleton.features.game.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.santimattius.android.skeleton.core.ui.GameScaffold

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScaffold {
                GameDetailRoute()
            }
        }
    }
}
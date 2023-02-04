package com.santimattius.android.skeleton.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GameScaffold(
    topAppBar: @Composable () -> Unit = { GameTopAppBar() },
    content: @Composable () -> Unit,
) {
    AndroidSkeletonContainer {
        Scaffold(
            topBar = topAppBar
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                content()
            }
        }
    }
}
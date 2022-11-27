package com.santimattius.android.skeleton.core.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santimattius.android.skeleton.core.ui.theme.AndroidSkeletonTheme

@Composable
fun AndroidSkeletonContainer(content: @Composable () -> Unit) {
    AndroidSkeletonTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            content = content,
        )
    }

}
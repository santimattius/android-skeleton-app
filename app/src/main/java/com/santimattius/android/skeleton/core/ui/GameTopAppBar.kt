package com.santimattius.android.skeleton.core.ui

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.santimattius.android.skeleton.R

@Composable
fun GameTopAppBar(title: String = stringResource(id = R.string.app_name)) {
    TopAppBar(
        title = {
            Text(text = title)
        })
}
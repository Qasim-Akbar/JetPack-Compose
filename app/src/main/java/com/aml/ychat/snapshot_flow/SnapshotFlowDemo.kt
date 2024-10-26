package com.aml.ychat.snapshot_flow

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull

@Composable
fun SnapshotFlowDemo(){
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = snackbarHostState) {
        snapshotFlow { snackbarHostState }
            .mapNotNull { it.currentSnackbarData }
            .distinctUntilChanged()
            .collect{ message ->
                println("A Snackbar with message $message wa shown")
            }
    }
}
package com.simplemobiletools.commons.compose.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.simplemobiletools.commons.R
import com.simplemobiletools.commons.compose.alert_dialog.rememberAlertDialogState
import com.simplemobiletools.commons.dialogs.ConfirmationAlertDialog
import com.simplemobiletools.commons.extensions.launchViewIntent

@Composable
fun FakeVersionCheck() {
    val context = LocalContext.current
    val confirmationDialogAlertDialogState = rememberAlertDialogState().apply {
        DialogMember {
            ConfirmationAlertDialog(
                alertDialogState = this,
                positive = R.string.ok,
                negative = null,
                message = FAKE_VERSION_APP_LABEL
            ) {
                context.getActivity().launchViewIntent(DEVELOPER_PLAY_STORE_URL)
            }
        }
    }
    LaunchedEffect(Unit) {
        context.fakeVersionCheck(confirmationDialogAlertDialogState::show)
    }
}

@Composable
fun CheckAppOnSdCard() {
    val context = LocalContext.current.getComponentActivity()
    val confirmationDialogAlertDialogState = rememberAlertDialogState().apply {
        DialogMember {
            ConfirmationAlertDialog(
                alertDialogState = this,
                positive = R.string.ok,
                negative = null,
                messageId = R.string.app_on_sd_card
            ) {}
        }
    }
    LaunchedEffect(Unit) {
        context.appOnSdCardCheckCompose(confirmationDialogAlertDialogState::show)
    }
}

package com.flixclusive.domain.model

import androidx.annotation.StringRes
import com.flixclusive.R
import com.flixclusive.common.UiText

sealed class VideoDataDialogState(val message: UiText) {
    companion object {
        @StringRes private val defaultUnavailableMessageId = R.string.video_data_dialog_state_unavailable_default
        @StringRes private val defaultErrorMessageId = R.string.video_data_dialog_state_error_default
    }
    
    object Idle : VideoDataDialogState(message = UiText.StringValue(""))
    object Fetching :
        VideoDataDialogState(message = UiText.StringResource(R.string.video_data_dialog_state_fetching))

    object Extracting :
        VideoDataDialogState(message = UiText.StringResource(R.string.video_data_dialog_state_extracting))

    class Error(
        errorMessage: UiText? = null,
    ) : VideoDataDialogState(
        message = errorMessage
            ?: UiText.StringResource(defaultErrorMessageId)
    ) {
        constructor(@StringRes errorMessageId: Int) : this(
            errorMessage = UiText.StringResource(errorMessageId)
        )
    }

    class Unavailable(errorMessage: UiText? = null) :
        VideoDataDialogState(
            message = errorMessage ?: UiText.StringResource(defaultUnavailableMessageId)
        ) {
        constructor(@StringRes errorMessageId: Int) : this(
            errorMessage = UiText.StringResource(errorMessageId)
        )
    }

    object Success :
        VideoDataDialogState(message = UiText.StringResource(R.string.video_data_dialog_state_success))
}
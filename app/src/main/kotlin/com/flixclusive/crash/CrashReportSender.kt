package com.flixclusive.crash

import android.content.Context
import com.flixclusive.core.ui.common.util.showToast
import com.flixclusive.core.util.common.dispatcher.di.ApplicationScope
import com.flixclusive.core.util.network.POST
import com.flixclusive.core.util.network.asString
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import javax.inject.Inject
import com.flixclusive.core.util.R as UtilR

internal const val errorReportFormUrl = "https://docs.google.com/forms/u/0/d/e/1FAIpQLSfTVmgiOeF7RlDbjBR10RQG6C6uKioSk-toqKecPvpkAe9ffw/formResponse?pli=1"

interface CrashReportSender {
    /**
     *
     * Sends error logs to server (docs forms).
     *
     * @param errorLog error log/stack trace/message
     *
     * @return true if it was sent successfully, otherwise false.
     * */
    fun send(errorLog: String)
}

internal class DefaultCrashReportSender @Inject constructor(
    private val client: OkHttpClient,
    @ApplicationContext private val context: Context,
    @ApplicationScope private val scope: CoroutineScope
) : CrashReportSender {
    override fun send(errorLog: String) {
        scope.launch {
            val response = client.newCall(
                POST(
                    url = errorReportFormUrl,
                    data = mapOf("entry.1687138646" to errorLog)
                )
            ).execute()
            val responseString = response.body?.charStream().asString()

            val isSent = response.isSuccessful
                    && (responseString?.contains("form_confirm", true) == true || responseString?.contains("submit another response", true) == true)

            if(!isSent) {
                context.run {
                    showToast(getString(UtilR.string.fail_sending_error_log))
                }
            }
        }
    }
}
package com.flixclusive.core.util.log

import android.util.Log

const val FLIXCLUSIVE_LOG_TAG = "FlixclusiveLog"

/**
 * Logs a debug message with the specified [message].
 * @param message The message to log.
 */
fun debugLog(message: String) = Log.d(FLIXCLUSIVE_LOG_TAG, message)

/**
 * Logs an error message with the specified [message].
 * @param message The message to log.
 */
fun errorLog(message: String) = Log.e(FLIXCLUSIVE_LOG_TAG, message)

/**
 * Logs an informational message with the specified [message].
 * @param message The message to log.
 */
fun infoLog(message: String) = Log.i(FLIXCLUSIVE_LOG_TAG, message)

/**
 * Logs a verbose message with the specified [message].
 * @param message The message to log.
 */
fun verboseLog(message: String) = Log.v(FLIXCLUSIVE_LOG_TAG, message)

/**
 * Logs a warning message with the specified [message].
 * @param message The message to log.
 */
fun warnLog(message: String) = Log.w(FLIXCLUSIVE_LOG_TAG, message)

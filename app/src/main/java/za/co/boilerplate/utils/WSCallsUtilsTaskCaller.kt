package za.co.boilerplate.utils

import android.app.Activity

interface WSCallsUtilsTaskCaller {
    fun taskCompleted(response: String?, reqCode: Int)
    val activity: Activity?
}
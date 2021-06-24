package za.co.boilerplate.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import za.co.boilerplate.BuildConfig

object GeneralUtils {
    fun makeToast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun openAppSettingsScreen(context: Context) {
        val settingsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + BuildConfig.APPLICATION_ID))
        settingsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(settingsIntent)
    }
}
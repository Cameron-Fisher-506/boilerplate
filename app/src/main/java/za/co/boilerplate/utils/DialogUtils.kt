package za.co.boilerplate.utils

import android.app.AlertDialog
import android.content.Context
import za.co.boilerplate.dialogs.PermissionCallback

object DialogUtils {
    fun createAlertPermission(context: Context?, title: String?, message: String?, isPrompt: Boolean, permissionCallback: PermissionCallback): AlertDialog? {
        var toReturn: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        if (isPrompt) {
            builder.setCancelable(true)
            builder.setPositiveButton("Yes") { dialog, _ ->
                permissionCallback.checkPermission(true)
                dialog.cancel()
            }
            builder.setNegativeButton("No") { dialog, _ -> dialog.cancel() }
        } else {
            builder.setCancelable(false)
            builder.setPositiveButton("Okay") { dialog, _ -> dialog.cancel() }
        }
        toReturn = builder.create()
        return toReturn
    }
}
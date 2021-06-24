package za.co.boilerplate.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log

object DeviceUtils {
    fun getIMEI(context: Context): String? {
        var toReturn: String? = null
        try {
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            toReturn = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                telephonyManager.imei
            } else {
                telephonyManager.deviceId
            }
        } catch (e: SecurityException) // What exception?
        {
            Log.d(ConstantUtils.TAG, "Class: DeviceUtils " +
                    "Method: getIMEI " +
                    "Error: ${e.message} " +
                    "CreatedTime: ${DTUtils.getCurrentDateTime()}")
        } catch (e: Exception) {
            Log.d(ConstantUtils.TAG, "Class: DeviceUtils " +
                    "Method: getIMEI " +
                    "Error: ${e.message} " +
                    "CreatedTime: ${DTUtils.getCurrentDateTime()}")
        }
        return toReturn
    }

    fun getBatteryLevel(context: Context): String? {
        var toReturn: String? = null
        try {
            val bm = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
            if (bm != null) {
                val batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
                toReturn = "$batLevel%"
            }
        } catch (e: Exception) {
            Log.d(ConstantUtils.TAG, "Method: DeviceUtils - getBatteryLevel " +
                    "Message: ${e.message} " +
                    "CreatedTime: ${DTUtils.getCurrentDateTime()}")
        }
        return toReturn
    }

    fun getNetworkType(context: Context): String? {
        var toReturn: String? = null
        try {
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            when (telephonyManager.networkType) {
                TelephonyManager.NETWORK_TYPE_1xRTT -> toReturn = "1xRTT"
                TelephonyManager.NETWORK_TYPE_CDMA -> toReturn = "CDMA"
                TelephonyManager.NETWORK_TYPE_EDGE -> toReturn = "EDGE"
                TelephonyManager.NETWORK_TYPE_EHRPD -> toReturn = "eHRPD"
                TelephonyManager.NETWORK_TYPE_EVDO_0 -> toReturn = "EVDO rev. 0"
                TelephonyManager.NETWORK_TYPE_EVDO_A -> toReturn = "EVDO rev. A"
                TelephonyManager.NETWORK_TYPE_EVDO_B -> toReturn = "EVDO rev. B"
                TelephonyManager.NETWORK_TYPE_GPRS -> toReturn = "GPRS"
                TelephonyManager.NETWORK_TYPE_HSDPA -> toReturn = "HSDPA"
                TelephonyManager.NETWORK_TYPE_HSPA -> toReturn = "HSPA"
                TelephonyManager.NETWORK_TYPE_HSPAP -> toReturn = "HSPA+"
                TelephonyManager.NETWORK_TYPE_HSUPA -> toReturn = "HSUPA"
                TelephonyManager.NETWORK_TYPE_IDEN -> toReturn = "iDen"
                TelephonyManager.NETWORK_TYPE_LTE -> toReturn = "LTE"
                TelephonyManager.NETWORK_TYPE_UMTS -> toReturn = "UMTS"
                TelephonyManager.NETWORK_TYPE_UNKNOWN -> toReturn = "Unknown"
            }
        } catch (e: Exception) {
            Log.d(ConstantUtils.TAG, "Method: DeviceUtils - getNetworkType " +
                    "Message: ${e.message} " +
                    "CreatedTime: ${DTUtils.getCurrentDateTime()}")
        }
        return toReturn
    }

    fun isRoaming(context: Context): Boolean {
        val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connManager.activeNetworkInfo
        return if (networkInfo == null || !networkInfo.isConnected) {
            // No connection will be seen as roaming as it cannot be established reliably
            true
        } else {
            val networkType = connManager.activeNetworkInfo
            networkType!!.isRoaming
        }
    }
}
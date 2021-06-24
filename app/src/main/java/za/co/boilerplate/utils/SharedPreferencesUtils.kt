package za.co.boilerplate.utils

import android.content.Context
import android.util.Log
import org.json.JSONObject
import za.co.boilerplate.utils.DTUtils.getCurrentDateTime

object SharedPreferencesUtils {
    const val PRIVACY_POLICY_ACCEPTANCE = "PRIVACY_POLICY_ACCEPTANCE"

    fun save(context: Context, sharedPrefName: String?, jsonObject: JSONObject) {
        val sharedPreferences = context.getSharedPreferences(sharedPrefName, 0)
        val editor = sharedPreferences.edit()
        editor.putString(sharedPrefName, jsonObject.toString())
        editor.apply()
    }

    operator fun get(context: Context, sharedPrefName: String?): JSONObject? {
        var toReturn: JSONObject? = null
        try {
            val sharedPreferences = context.getSharedPreferences(sharedPrefName, 0)
            if (sharedPreferences != null && sharedPreferences.contains(sharedPrefName)) {
                val value = sharedPreferences.getString(sharedPrefName, "DEFAULT")
                if (value != null && value != "") {
                    toReturn = JSONObject(value)
                }
            }
        } catch (e: Exception) {
            Log.e(ConstantUtils.TAG, " Error: ${e.message} " +
                    "Method: SharedPreferencesUtils - get " +
                    "CreatedTime: ${getCurrentDateTime()}")
        }
        return toReturn
    }
}
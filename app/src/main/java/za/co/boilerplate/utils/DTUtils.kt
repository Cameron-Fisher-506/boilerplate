package za.co.boilerplate.utils

import java.text.SimpleDateFormat
import java.util.*

object DTUtils {
    @JvmStatic
    fun getCurrentDateTime(): String {
        var toReturn = ""
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        var now = Date()
        val calendar = Calendar.getInstance()
        calendar.time = now
        now = calendar.time
        toReturn = simpleDateFormat.format(now)
        return toReturn
    }
}
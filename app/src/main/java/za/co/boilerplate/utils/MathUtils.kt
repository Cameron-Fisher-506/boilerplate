package za.co.boilerplate.utils

import java.text.DecimalFormat

object MathUtils {
    fun precision(value: Double?): Double? {
        var toReturn: Double? = null
        if (value != null) {
            val decimalFormat = DecimalFormat("#,##")
            toReturn = java.lang.Double.valueOf(decimalFormat.format(value))
        }
        return toReturn
    }
}
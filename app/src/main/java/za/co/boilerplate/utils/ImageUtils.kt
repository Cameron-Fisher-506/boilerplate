package za.co.boilerplate.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable

object ImageUtils {
    fun createBitmap(context: Context, width: Int, height: Int, resource: Int): Bitmap {
        val bitmapdraw = context.resources.getDrawable(resource) as BitmapDrawable
        val b = bitmapdraw.bitmap
        return Bitmap.createScaledBitmap(b, width, height, false)
    }
}
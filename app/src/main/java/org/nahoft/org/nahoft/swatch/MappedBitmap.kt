package org.nahoft.org.nahoft.swatch

import android.graphics.Bitmap
import org.nahoft.swatch.lengthMessageSeed
import kotlin.random.Random

class MappedBitmap(var bitmap: Bitmap, key: Int) {
    var mapping: IntArray

    init {
        val numberOfPixels = bitmap.height * bitmap.width
        val random = Random(key)
        mapping = IntArray(numberOfPixels) { it }
        mapping.shuffle(random)
    }

    val width: Int
        get() = bitmap.width

    fun getPixel(index: Int): Int {
        val mappedIndex = mapping[index]

        val x = mappedIndex % bitmap.width
        val y = mappedIndex / bitmap.width

        return bitmap.getPixel(x, y)
    }

    fun setPixel(index: Int, color: Int) {
        val mappedIndex = mapping[index]

        val x = mappedIndex % bitmap.width
        val y = mappedIndex / bitmap.width

        return bitmap.setPixel(x, y, color)
    }
}
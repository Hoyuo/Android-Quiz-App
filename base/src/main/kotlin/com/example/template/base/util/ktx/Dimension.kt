package com.example.template.base.util.ktx

import android.content.Context
import android.content.res.Resources

val Context.statusBarHeight: Int
    get() = resources.statusBarHeight

val Resources.statusBarHeight: Int
    get() {
        val resourceId = getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            this.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }

val Context.displayWidth: Int
    get() = resources.displayWidth

val Resources.displayWidth: Int
    get() = displayMetrics.widthPixels

val Context.displayHeight: Int
    get() = resources.displayHeight

val Resources.displayHeight: Int
    get() = displayMetrics.heightPixels

val Context.displayDensity: Float
    get() = resources.displayDensity

val Resources.displayDensity: Float
    get() = displayMetrics.density

val Int.dp: Int
    get() = (this * Resources.getSystem().displayDensity).toInt()

val Int.px: Int
    get() = (this / Resources.getSystem().displayDensity).toInt()

val Float.dp: Float
    get() = this * Resources.getSystem().displayDensity

val Float.px: Float
    get() = this / Resources.getSystem().displayDensity

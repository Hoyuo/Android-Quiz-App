package com.example.template.logger

import android.util.Log
import timber.log.Timber

class TimberTree(
    private val tag: String,
) : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?,
    ) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            super.log(priority, this.tag, "$tag - $message", t)
        }
    }
}

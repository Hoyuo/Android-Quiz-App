package com.example.template.logger

import timber.log.Timber

class TimberTree(
    private val tag: String,
) : Timber.DebugTree() {
    override fun createStackElementTag(
        element: StackTraceElement,
    ): String = "(${element.fileName}:${element.lineNumber})#${element.methodName}"

    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?,
    ) {
        super.log(priority, this.tag, "$tag - $message", t)
    }
}

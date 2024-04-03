package com.example.template.internal

import java.util.Locale
import java.util.regex.Pattern

internal object Utils {
    private val WORD_SEPARATOR = Pattern.compile("\\W+")

    fun <T : CharSequence> toCamelCase(string: T?): String? = toCamelCase(string, false)

    fun <T : CharSequence> toCamelCase(
        string: T?,
        lower: Boolean,
    ): String? {
        if (string == null) {
            return null
        }
        val builder = StringBuilder()
        val matcher = WORD_SEPARATOR.matcher(string)
        var pos = 0
        var first = true
        while (matcher.find()) {
            var chunk = string.subSequence(pos, matcher.start()).toString()
            pos = matcher.end()
            if (chunk.isEmpty()) {
                continue
            }
            if (lower && first) {
                chunk = chunk.replaceFirstChar { it.lowercase(Locale.ROOT) }
                first = false
            } else {
                chunk =
                    chunk.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            }
            builder.append(chunk)
        }
        var rest = string.subSequence(pos, string.length).toString()
        rest =
            if (lower && first) {
                rest.replaceFirstChar { it.lowercase(Locale.ROOT) }
            } else {
                rest.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            }
        builder.append(rest)
        return builder.toString()
    }
}

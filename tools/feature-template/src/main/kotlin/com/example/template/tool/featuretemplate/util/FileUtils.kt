package com.example.template.tool.featuretemplate.util

import java.nio.file.Files
import java.nio.file.Path

fun save2(
    contents: String?,
    to: Path,
) {
    if (contents == null) {
        return
    }
    val toFile = to.toFile()
    if (toFile.exists().not()) {
        // Creating a new file
        toFile.createNewFile()
    }
    toFile.writeText(
        contents,
        Charsets.UTF_8,
    )
}

fun settingAppend(
    contents: String?,
    to: Path,
) {
    if (contents == null) {
        return
    }

    val toFile = to.toFile()

    if (toFile.exists().not()) {
        // Creating a new file
        throw Exception("File not exists")
    }

    toFile.appendText(
        contents,
        Charsets.UTF_8,
    )
}

fun featureAppend(
    contents: String?,
    to: Path,
) {
    if (contents == null) {
        return
    }

    val toFile = to.toFile()

    if (toFile.exists().not()) {
        // Creating a new file
        throw Exception("File not exists")
    }

    val body = String(toFile.readBytes(), Charsets.UTF_8)
    val newContents =
        body.replace(
            "// endregion feature module",
            """
            $contents
            // endregion feature module
            """.trimIndent(),
        )
    Files.write(
        to,
        newContents.toByteArray(Charsets.UTF_8),
    )
}

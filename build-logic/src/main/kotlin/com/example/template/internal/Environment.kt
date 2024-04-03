package com.example.template.internal

val isArmProcessor: Boolean =
    Runtime.getRuntime().exec("uname -p")
        .inputStream
        .bufferedReader()
        .use { reader -> reader.readLine()?.trim() }
        .let { processor -> processor == "arm" }

package com.example.template.base.util.ktx

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build

fun Context.getPackageInfo(): PackageInfo? =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.packageManager.getPackageInfo(this.packageName, PackageManager.PackageInfoFlags.of(0))
    } else {
        this.packageManager.getPackageInfo(this.packageName, 0)
    }

val Context.appVersion: String
    get() = this.getPackageInfo()?.versionName ?: "0.0.0"

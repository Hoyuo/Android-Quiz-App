package com.example.template.base.util.ktx

import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String) {
    requireActivity().showToast(message)
}

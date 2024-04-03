package com.example.template.base.util.ktx

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

val Activity.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager

val Context.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    currentFocus?.let {
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Activity.showKeyboard() {
    currentFocus?.let {
        inputMethodManager.showSoftInput(it, 0)
    }
}

fun Activity.toggleKeyboard() {
    currentFocus?.let {
        if (inputMethodManager.isActive) {
            hideKeyboard()
        } else {
            showKeyboard()
        }
    }
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Fragment.showKeyboard() {
    activity?.showKeyboard()
}

fun Fragment.toggleKeyboard() {
    activity?.toggleKeyboard()
}

fun Context.hideKeyboard(view: View) {
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyboard(view: View) {
    inputMethodManager.showSoftInput(view, 0)
}

fun Context.toggleKeyboard(view: View) {
    if (inputMethodManager.isActive) {
        hideKeyboard(view)
    } else {
        showKeyboard(view)
    }
}

fun View.hideKeyboard() {
    context.hideKeyboard(this)
}

fun View.showKeyboard() {
    context.showKeyboard(this)
}

fun View.toggleKeyboard() {
    context.toggleKeyboard(this)
}

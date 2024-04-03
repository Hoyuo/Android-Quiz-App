package com.example.template.base.util.ktx

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:visibility")
fun View.setVisible(visible: Boolean?) {
    isVisible = visible == true
}

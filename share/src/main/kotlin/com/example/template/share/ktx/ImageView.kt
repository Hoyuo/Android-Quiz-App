package com.example.template.share.ktx

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:src")
fun ImageView.setSrc(imageUrl: String) {
    Glide
        .with(this)
        .load(imageUrl)
        .into(this)
}

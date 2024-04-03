package com.example.template.base.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingViewHolder<VH : ViewBinding, T>(
    protected open val binding: VH,
) : RecyclerView.ViewHolder(binding.root) {
    fun bindItem(item: T) = Unit

    protected fun bind(block: VH.() -> Unit) {
        binding.run(block)
    }
}

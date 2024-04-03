package com.example.template.base.ui.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseDataBindingViewHolder<VH : ViewDataBinding, T>(
    protected open val binding: VH,
) : RecyclerView.ViewHolder(binding.root) {
    protected abstract val variableId: Int?

    fun bindItem(item: T) {
        variableId?.let { id -> binding.setVariable(id, item) }
        binding.executePendingBindings()
    }

    protected fun bind(block: VH.() -> Unit) {
        binding.run(block)
    }
}

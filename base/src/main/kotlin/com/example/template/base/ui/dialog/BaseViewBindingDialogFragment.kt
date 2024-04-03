package com.example.template.base.ui.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.template.base.ui.effect.BaseEffect
import com.example.template.base.ui.viewmodel.BaseViewModel
import com.example.template.base.util.coroutines.repeatOnStarted

abstract class BaseViewBindingDialogFragment<B : ViewBinding, VM : BaseViewModel<E>, E : BaseEffect>(
    bindingInflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean) -> B,
) : BaseDialogFragment<B>(bindingInflater) {
    protected abstract val viewModel: VM

    override fun initObserver() {
        repeatOnStarted {
            viewModel.effect.collect {
                it?.let { initEffectObserver(it) }
                viewModel.clearEffect()
            }
        }
    }

    protected open fun initEffectObserver(effect: E) = Unit
}

package com.example.template.base.ui.activity

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.template.base.ui.effect.BaseEffect
import com.example.template.base.ui.viewmodel.BaseViewModel
import com.example.template.base.util.coroutines.repeatOnStarted

abstract class BaseViewBindingActivity<B : ViewBinding, VM : BaseViewModel<E>, E : BaseEffect>(
    bindingInflater: (layoutInflater: LayoutInflater) -> B,
) : BaseActivity<B>(bindingInflater) {
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

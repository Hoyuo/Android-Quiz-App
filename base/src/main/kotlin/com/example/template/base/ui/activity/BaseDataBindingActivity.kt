package com.example.template.base.ui.activity

import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import com.example.template.base.ui.effect.BaseEffect
import com.example.template.base.ui.viewmodel.BaseViewModel
import com.example.template.base.util.coroutines.repeatOnStarted

abstract class BaseDataBindingActivity<B : ViewDataBinding, VM : BaseViewModel<E>, E : BaseEffect>(
    bindingInflater: (layoutInflater: LayoutInflater) -> B,
) : BaseActivity<B>(bindingInflater) {
    protected abstract val viewModel: VM

    protected abstract val viewModelVariableId: Int?

    override fun initViews() {
        bind {
            lifecycleOwner = this@BaseDataBindingActivity
            viewModelVariableId?.let { variableId ->
                setVariable(variableId, viewModel)
            }
        }
    }

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

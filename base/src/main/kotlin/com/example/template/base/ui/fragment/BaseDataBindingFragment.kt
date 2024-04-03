package com.example.template.base.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.template.base.ui.effect.BaseEffect
import com.example.template.base.ui.viewmodel.BaseViewModel
import com.example.template.base.util.coroutines.repeatOnStarted

abstract class BaseDataBindingFragment<B : ViewDataBinding, VM : BaseViewModel<E>, E : BaseEffect>(
    bindingInflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean) -> B,
) : BaseFragment<B>(bindingInflater) {
    protected abstract val viewModel: VM

    protected abstract val viewModelVariableId: Int?

    override fun initViews() {
        bind {
            lifecycleOwner = viewLifecycleOwner
            viewModelVariableId?.let { id -> setVariable(id, viewModel) }
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

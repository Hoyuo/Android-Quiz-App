package com.example.template.feature.home

import androidx.fragment.app.viewModels
import com.example.template.base.ui.fragment.BaseDataBindingFragment
import com.example.template.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding, HomeViewModel, HomeViewEffect>(FragmentHomeBinding::inflate) {
    override val viewModel: HomeViewModel by viewModels()

    override val viewModelVariableId = BR.vm

    override fun initViews() = Unit

    override fun initEffectObserver(effect: HomeViewEffect) = Unit
}

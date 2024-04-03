package com.example.template.feature.home

import com.example.template.base.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor() : BaseViewModel<HomeViewEffect>()

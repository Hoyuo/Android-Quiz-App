package com.example.template.presentation

import com.example.template.base.ui.activity.BaseActivity
import com.example.template.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate)

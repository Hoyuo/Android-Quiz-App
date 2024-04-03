package com.example.template.base.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(
    private val bindingInflater: (layoutInflater: LayoutInflater) -> B,
) : AppCompatActivity() {
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    protected open fun initViews() = Unit

    protected open fun initObserver() = Unit

    protected fun bind(block: B.() -> Unit) {
        binding.run(block)
    }
}

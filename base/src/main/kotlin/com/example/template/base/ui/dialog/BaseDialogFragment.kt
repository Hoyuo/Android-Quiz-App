package com.example.template.base.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<B : ViewBinding>(
    private val bindingInflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean) -> B,
) : DialogFragment() {
    @Suppress("ktlint:standard:backing-property-naming")
    private var _binding: B? = null
    protected val binding: B
        get() = requireNotNull(_binding)

    override fun getTheme(): Int = android.R.style.Theme_Material_Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        initObserver()
    }

    protected open fun initObserver() = Unit

    protected open fun initViews() = Unit

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun bind(block: B.() -> Unit) {
        binding.run(block)
    }
}

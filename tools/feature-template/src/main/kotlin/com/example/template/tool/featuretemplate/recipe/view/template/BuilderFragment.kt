package com.example.template.tool.featuretemplate.recipe.view.template

fun fragmentBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        package $packageName

        import androidx.fragment.app.viewModels
        import com.example.template.base.ui.fragment.BaseDataBindingFragment
        import com.example.template.feature.${featureName.lowercase()}.databinding.Fragment${featureName}Binding
        import dagger.hilt.android.AndroidEntryPoint

        @AndroidEntryPoint
        class ${featureName}Fragment : BaseDataBindingFragment<Fragment${featureName}Binding, ${featureName}ViewModel, ${featureName}ViewEffect>(Fragment${featureName}Binding::inflate) {
            override val viewModel: ${featureName}ViewModel by viewModels()

            override val viewModelVariableId = BR.vm

            override fun initViews() = Unit

            override fun initEffectObserver(effect: ${featureName}ViewEffect) = Unit
        }

        """.trimIndent()
}

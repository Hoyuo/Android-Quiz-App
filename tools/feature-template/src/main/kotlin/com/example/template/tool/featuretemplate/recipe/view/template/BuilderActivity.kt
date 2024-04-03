package com.example.template.tool.featuretemplate.recipe.view.template

fun activityBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        package $packageName

        import androidx.activity.viewModels
        import com.example.template.base.ui.activity.BaseDataBindingActivity
        import com.example.template.feature.${featureName.lowercase()}.databinding.Activity${featureName}Binding
        import dagger.hilt.android.AndroidEntryPoint

        @AndroidEntryPoint
        class ${featureName}Activity : BaseDataBindingActivity<Activity${featureName}Binding, ${featureName}ViewModel, ${featureName}ViewEffect>(Activity${featureName}Binding::inflate) {
            override val viewModel: ${featureName}ViewModel by viewModels()

            override val viewModelVariableId = BR.vm
        }

        """.trimIndent()
}

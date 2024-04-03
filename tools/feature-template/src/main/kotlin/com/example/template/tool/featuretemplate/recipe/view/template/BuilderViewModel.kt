package com.example.template.tool.featuretemplate.recipe.view.template

fun viewModelBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        package $packageName

        import com.example.template.base.ui.viewmodel.BaseViewModel
        import dagger.hilt.android.lifecycle.HiltViewModel
        import javax.inject.Inject

        @HiltViewModel
        class ${featureName}ViewModel
            @Inject
            constructor() : BaseViewModel<${featureName}ViewEffect>()

        """.trimIndent()
}

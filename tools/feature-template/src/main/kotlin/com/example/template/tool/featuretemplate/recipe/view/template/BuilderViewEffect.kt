package com.example.template.tool.featuretemplate.recipe.view.template

fun viewEffectBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        package $packageName

        import com.example.template.base.ui.effect.BaseEffect

        sealed interface ${featureName}ViewEffect : BaseEffect

        """.trimIndent()
}

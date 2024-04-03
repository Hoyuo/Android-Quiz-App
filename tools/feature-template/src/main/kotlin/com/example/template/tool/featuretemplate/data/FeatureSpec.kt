package com.example.template.tool.featuretemplate.data

data class FeatureSpec(
    private val name: String,
    val project: ProjectUiType,
    val viewType: ViewType,
) {
    private val packageNamePrefix = "com.example.template.feature"

    val rootPath = "feature/${name.lowercase()}"

    val srcPath = "$packageNamePrefix/${name.lowercase()}".replace(".", "/")

    val featureName = name.replaceFirstChar { it.uppercase() }
    val packageName: String
        get() = "$packageNamePrefix.${name.lowercase()}"

    override fun toString(): String {
        return """| FeatureName: $name
            | packageName: $packageName
            | project: $project
            | type: $viewType
            """.trimMargin()
    }
}

enum class ViewType {
    Activity,
    Fragment,
}

enum class ProjectUiType {
    View,
}

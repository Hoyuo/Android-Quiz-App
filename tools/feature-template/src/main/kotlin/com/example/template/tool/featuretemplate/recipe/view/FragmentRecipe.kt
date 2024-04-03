package com.example.template.tool.featuretemplate.recipe.view

import com.example.template.tool.featuretemplate.data.FeatureSpec
import com.example.template.tool.featuretemplate.recipe.common.gitignoreBuilder
import com.example.template.tool.featuretemplate.recipe.common.gradleScriptViewBuilder
import com.example.template.tool.featuretemplate.recipe.common.layoutXmlBuilder
import com.example.template.tool.featuretemplate.recipe.common.navigationBuilder
import com.example.template.tool.featuretemplate.recipe.common.stringResourceBuilder
import com.example.template.tool.featuretemplate.recipe.view.template.bindingAdapterBuilder
import com.example.template.tool.featuretemplate.recipe.view.template.fragmentBuilder
import com.example.template.tool.featuretemplate.recipe.view.template.viewEffectBuilder
import com.example.template.tool.featuretemplate.recipe.view.template.viewModelBuilder
import com.example.template.tool.featuretemplate.util.camelToSnakeCase
import com.example.template.tool.featuretemplate.util.featureAppend
import com.example.template.tool.featuretemplate.util.save2
import com.example.template.tool.featuretemplate.util.settingAppend
import java.nio.file.Path
import java.nio.file.Paths

fun generateViewFragment(
    srcOut: Path,
    resOut: Path,
    spec: FeatureSpec,
) {
    val featureName = spec.featureName
    val packageRoot = spec.rootPath
    val packageName = spec.packageName
    val resourceName = featureName.camelToSnakeCase()

    val rootOut = packageRoot.let { Paths.get("").resolve(it) }

    resOut.toFile().mkdirs()
    resOut.resolve("layout").toFile().mkdirs()
    resOut.resolve("values").toFile().mkdirs()
    resOut.resolve("navigation").toFile().mkdirs()
    resOut.resolve("drawable").toFile().mkdirs()

    // gitignore
    save2(
        gitignoreBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        rootOut.resolve(".gitignore"),
    )

    // gradle
    save2(
        gradleScriptViewBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        rootOut.resolve("build.gradle.kts"),
    )

    // fragment
    save2(
        fragmentBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        srcOut.resolve("${featureName}Fragment.kt"),
    )
    // viewmodel
    save2(
        viewModelBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        srcOut.resolve("${featureName}ViewModel.kt"),
    )

    // viewEffect
    save2(
        viewEffectBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        srcOut.resolve("${featureName}ViewEffect.kt"),
    )

    // bindingAdapter
    save2(
        bindingAdapterBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        srcOut.resolve("${featureName}BindingAdapter.kt"),
    )

    // layout Xml
    save2(
        layoutXmlBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        resOut.resolve("layout/fragment_$resourceName.xml"),
    )

    // navigation graph
    save2(
        navigationBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        resOut.resolve("navigation/nav_$resourceName.xml"),
    )

    // string
    save2(
        stringResourceBuilder(featureName = featureName, resourceName = resourceName, packageName = packageName),
        resOut.resolve("values/strings.xml"),
    )

    // settings.gradle.kts include ':feature:${featureName}'
    settingAppend(
        contents = "include(\":feature:${featureName.lowercase()}\")\n",
        to = Paths.get("").resolve("settings.gradle.kts"),
    )

    featureAppend(
        contents = "implementation(projects.feature.${featureName.lowercase()})\n",
        to = Paths.get("").resolve("presentation/build.gradle.kts"),
    )
}

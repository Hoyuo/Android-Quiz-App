package com.example.template.tool.featuretemplate.form

import com.example.template.tool.featuretemplate.data.FeatureSpec
import com.example.template.tool.featuretemplate.data.ProjectUiType
import com.example.template.tool.featuretemplate.data.ViewType
import com.github.kinquirer.KInquirer
import com.github.kinquirer.components.promptInput
import com.github.kinquirer.components.promptListObject
import com.github.kinquirer.core.Choice

fun interactiveSpecCollector(): FeatureSpec {
    val featureName =
        KInquirer.promptInput(
            message = "featureName (feature module root name)",
            hint = "feature.{featureName}",
        ).trim()

    val project = ProjectUiType.View

    val viewType =
        KInquirer.promptListObject(
            "select Detail Ui type",
            listOf(
                Choice("Activity", ViewType.Activity),
                Choice("Fragment", ViewType.Fragment),
            ),
        )

    return FeatureSpec(
        name = featureName,
        project = project,
        viewType = viewType,
    )
}

package com.example.template.tool.featuretemplate.recipe

import com.example.template.tool.featuretemplate.data.FeatureSpec
import com.example.template.tool.featuretemplate.data.ViewType
import com.example.template.tool.featuretemplate.recipe.view.generateViewActivity
import com.example.template.tool.featuretemplate.recipe.view.generateViewFragment
import java.nio.file.Path

fun generateFeature(
    srcOut: Path,
    resOut: Path,
    featureSpec: FeatureSpec,
) {
    when (featureSpec.viewType) {
        ViewType.Activity -> generateViewActivity(srcOut, resOut, featureSpec)
        ViewType.Fragment -> generateViewFragment(srcOut, resOut, featureSpec)
    }
}

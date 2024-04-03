package com.example.template.tool.featuretemplate

import com.example.template.tool.featuretemplate.form.interactiveSpecCollector
import com.example.template.tool.featuretemplate.recipe.generateFeature
import com.github.kinquirer.KInquirer
import com.github.kinquirer.components.promptConfirm
import java.nio.file.Paths

fun main() {
    val featureSpec = interactiveSpecCollector()

    val rootPath = featureSpec.rootPath

    val srcPathStr = "$rootPath/src/main/kotlin/${featureSpec.srcPath}"
    val srcDir = Paths.get("").resolve(srcPathStr)

    val resPathStr = "$rootPath/src/main/res"
    val resDir = Paths.get("").resolve(resPathStr)

    val confirmed =
        KInquirer.promptConfirm(
            "Create Feature ->\n" +
                "$featureSpec\n" +
                " srcOut: $srcDir\n" +
                " resOut: $resDir\n",
        )

    if (confirmed) {
        srcDir.toFile().mkdirs()

        generateFeature(
            srcOut = srcDir,
            resOut = resDir,
            featureSpec = featureSpec,
        )
    }
}

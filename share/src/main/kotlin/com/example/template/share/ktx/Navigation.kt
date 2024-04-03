package com.example.template.share.ktx

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.navOptions
import com.example.template.share.R

fun NavController.animNavigate(directions: NavDirections) {
    navigate(
        directions,
        navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        },
    )
}

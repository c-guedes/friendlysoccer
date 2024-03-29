package com.br.friendlysoccer.ext

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.br.friendlysoccer.ui.common.NavigationRequest

fun NavController.navigate(
    request: NavigationRequest,
    activity: FragmentActivity? = null,
    fragmentManager: FragmentManager? = null
) {
    when (request) {
        is NavigationRequest.Pop -> {
            if (request.destinationId != null && (request.destinationId > 0)) popBackStack(
                request.destinationId,
                request.inclusive
            )
            else popBackStack()
        }
        is NavigationRequest.PopToRoot -> popBackStack(
            graph.startDestination,
            request.inclusive
        )
        is NavigationRequest.Push -> navigate(
            request.destinationId,
            request.args,
            request.options,
            request.extras
        )
//        is NavigationRequest.Dialog -> {
//            val tag: String = request.tag ?: request.destination.getClassTag()
//
//            val fm = fragmentManager ?: activity?.supportFragmentManager
//            ?: throw IllegalArgumentException("You cannot navigate to a Dialog using NavController.navigate without either an activity or a fragmentManager argument")
//            request.destination.show(fm, tag)
//        }
        is NavigationRequest.Finish -> {
            requireNotNull(activity) { "You cannot finish an Activity using NavController.navigate with a null activity argument" }
            activity.finish()
        }
    }
}
package com.app.mentoriaandroid.features.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.mentoriaandroid.features.detail.presentation.ui.screen.DetailScreen
import com.app.mentoriaandroid.features.detail.presentation.viewmodel.DetailViewModel
import com.app.mentoriaandroid.features.home.presentation.ui.screen.HomeScreen
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import com.app.mentoriaandroid.features.navigation.screen.Screen


@Composable
internal fun NavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    detailViewModel: DetailViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(viewModel = homeViewModel)
        }
        composable(
            route = Screen.CharacterDetails.route,
            arguments = listOf(navArgument("infoCharacters") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("infoCharacters")
                ?.let { DetailScreen(viewModel = detailViewModel, navController = navController) }
        }
    }
}
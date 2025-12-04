package com.example.database.view.uicontroller

import EntrySiswaScreen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.database.view.DetailDataSiswa
import com.example.database.view.DetailSiswaScreen
import com.example.database.view.EditSiswaScreen
import com.example.database.view.HomeScreen
import com.example.database.view.route.DestinasiEditSiswa
import com.example.database.view.route.DestinasiHome
import com.example.database.view.route.DestinasiEntry
import com.example.myroomsiswa.view.route.DestinasiDetailSiswa
import com.example.myroomsiswa.view.route.DestinasiDetailSiswa.itemIdArg

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { navController.navigate("${DestinasiDetailSiswa.route}/${it}")}
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg)
            {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateBack = {navController.navigateUp()}
            )
        }

        composable(
            DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg){
                type = NavType.IntType
            })
        ){
            EditSiswaScreen(
                navigateBack = { navController.popBackStack()},
                onNavigateUp = { navController.navigateUp()}
            )
        }
    }
}
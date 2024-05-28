@file:OptIn(ExperimentalMaterial3Api::class)

package com.diegocunha

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.diegocunha.about.ui.AboutScreen
import com.diegocunha.coreui.components.AppDrawerItemInfo
import com.diegocunha.coreui.components.PetNavigationDrawer
import com.diegocunha.coreui.theme.PetsTheme
import com.diegocunha.discoverypet.ui.home.HomeScreen
import com.diegocunha.findpets.R
import com.diegocunha.navigation.route.DEFAULT_ID_FIELD
import com.diegocunha.navigation.route.FindPetRoute
import com.diegocunha.navigation.route.navigate
import com.diegocunha.petdetail.ui.detail.PetDetailScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainCompose()
        }
    }
}

@Composable
fun MainCompose() {
    val navController = rememberNavController()
    LaunchedEffect(Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.i("MainActivity", "Destination: ${destination.route}")
        }
    }

    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var currentItem by remember {
        mutableStateOf(
            homeOption()
        )
    }

    PetsTheme {
        PetNavigationDrawer(
            drawerState = drawerState,
            menuItems = listOfDirections(),
            currentItem = currentItem,
            onItemClick = { petRoute ->
                navController.navigate(petRoute.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }

                    launchSingleTop = petRoute.route == navController.graph.startDestinationRoute
                    restoreState = true
                }

                currentItem =
                    checkNotNull(listOfDirections().find { it.drawerOption.route == petRoute.route })
            }
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = null)
                            }
                        },
                        title = { Text(text = stringResource(id = currentItem.title)) }
                    )
                },
                modifier = Modifier.fillMaxSize()
            ) { padding ->
                NavHost(
                    modifier = Modifier.padding(padding),
                    navController = navController,
                    startDestination = FindPetRoute.Home.route
                ) {
                    composable(FindPetRoute.Home.route) {
                        HomeScreen {
                            navController.navigate(FindPetRoute.PetDetail.navigate(it))
                        }
                    }

                    composable(FindPetRoute.About.route) {
                        AboutScreen()
                    }

                    composable(
                        FindPetRoute.PetDetail.route,
                        arguments = listOf(navArgument(DEFAULT_ID_FIELD) {
                            type = NavType.LongType
                        })
                    ) { backStackEntry ->
                        val id = checkNotNull(backStackEntry.arguments?.getLong(DEFAULT_ID_FIELD))
                        PetDetailScreen(id = id)
                    }
                }
            }
        }
    }
}

private fun listOfDirections() = listOf<AppDrawerItemInfo<FindPetRoute>>(
    homeOption(),
    AppDrawerItemInfo(
        drawerOption = FindPetRoute.About,
        title = R.string.menu_about,
        icon = Icons.Filled.Info
    )
)

private fun homeOption(): AppDrawerItemInfo<FindPetRoute> = AppDrawerItemInfo(
    drawerOption = FindPetRoute.Home,
    title = R.string.menu_home,
    icon = Icons.Filled.Home,
)

private fun findItem(route: String) =
    listOfDirections().find { it.drawerOption.route == route }?.drawerOption

@Preview
@Composable
fun MainActivityPreview() {
    MainCompose()
}
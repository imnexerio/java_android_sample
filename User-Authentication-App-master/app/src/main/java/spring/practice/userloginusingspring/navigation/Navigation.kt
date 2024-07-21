package spring.practice.userloginusingspring.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import spring.practice.userloginusingspring.data.repo.UserRepository
import spring.practice.userloginusingspring.data.vm.UserViewModel
import spring.practice.userloginusingspring.screens.MainScreen
import spring.practice.userloginusingspring.screens.SignInScreen
import spring.practice.userloginusingspring.screens.SignUpScreen

@Composable
fun AppNavigation(context:Context){

    val navController= rememberNavController()

    val userRepository = UserRepository()
    val userViewModel = UserViewModel(userRepository)
    
    NavHost(navController = navController, startDestination = Screens.MainScreen.route){
        composable(route=Screens.MainScreen.route){
            MainScreen(navController)
        }

        composable(route=Screens.SignInScreen.route){
            SignInScreen()
        }

        composable(route=Screens.SignUpScreen.route){
            SignUpScreen(context, navController, userViewModel)
        }
    }
}
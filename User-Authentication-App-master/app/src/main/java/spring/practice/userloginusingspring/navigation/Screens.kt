package spring.practice.userloginusingspring.navigation

sealed class Screens(val route:String) {

    object MainScreen: Screens("mainScreen")
    object SignUpScreen: Screens("signUpScreen")
    object SignInScreen: Screens("signInScreen")
    object SignInScreenConfirmation: Screens("signInScreenConf")
    object SignUpScreenConfirmation: Screens("signUpScreenConf")

}
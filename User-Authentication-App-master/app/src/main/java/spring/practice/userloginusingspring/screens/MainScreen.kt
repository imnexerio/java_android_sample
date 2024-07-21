package spring.practice.userloginusingspring.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import spring.practice.userloginusingspring.navigation.Screens

@Composable
fun MainScreen(navController: NavController?=null){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Welcome Text
            Text(
                text = "Welcome to the \n Login App",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            //Sign In Button
            Button(
                onClick = { navController?.navigate(Screens.SignInScreen.route) },
                modifier = Modifier.padding(top=48.dp)
            ) {
                Text(text = "Sign In")
            }

            //Sign Up Button
            Button(
                onClick = { navController?.navigate(Screens.SignUpScreen.route) },
                modifier = Modifier.padding(bottom=32.dp)

            ) {
                Text(text = "Sign Up")
            }

            //Description
            Text(
                text = "(This App is created to implement Spring Boot in Login Functionality, " +
                        "\n That is why, main focus is not the UI.)",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMainScreen(){
    MainScreen(navController = null)
}
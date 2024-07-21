package spring.practice.userloginusingspring.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import spring.practice.userloginusingspring.data.model.UserData
import spring.practice.userloginusingspring.data.vm.UserViewModel
import spring.practice.userloginusingspring.navigation.Screens
import java.time.LocalDateTime

@Composable
fun SignUpScreen(context: Context, navController: NavController?=null, userViewModel: UserViewModel){


    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var anyFieldInteracted by remember {
        mutableStateOf(false)
    }


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            IconButton(onClick = {navController?.navigate(Screens.MainScreen.route)},) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                )
            }

            Text(
                text = "Sign UP",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            TextField(
                value = firstName,
                onValueChange = {firstName=it; anyFieldInteracted = true},
                placeholder = { Text("Enter your First Name") },
                isError=firstName.isEmpty() && anyFieldInteracted,
                label = {
                    if (firstName.isEmpty() && anyFieldInteracted) {
                        Text("This field is mandatory")
                    } else {
                        Text("First Name")
                    }
                },
                modifier = Modifier.padding(top=48.dp,bottom=16.dp)
            )

            TextField(
                value = lastName,
                onValueChange = {lastName = it; anyFieldInteracted = true},
                isError=lastName.isEmpty() && anyFieldInteracted,
                label = {
                    if (lastName.isEmpty() && anyFieldInteracted) {
                        Text("This field is mandatory")
                    } else {
                        Text("Last Name")
                    }
                },
                placeholder = {Text("Enter your Last Name")},
                modifier = Modifier.padding(top=16.dp,bottom=16.dp)
            )

            TextField(
                value = email,
                onValueChange = {email = it; anyFieldInteracted = true},
                isError=email.isEmpty() && anyFieldInteracted,
                label = {
                    if (email.isEmpty() && anyFieldInteracted) {
                        Text("This field is mandatory")
                    } else {
                        Text("Email")
                    }
                },
                placeholder={Text("Enter your Email")},
                modifier = Modifier.padding(top=16.dp,bottom=16.dp)
            )

            TextField(
                value = password,
                onValueChange = {password = it; anyFieldInteracted = true},
                isError=password.isEmpty() && anyFieldInteracted,
                label = {
                    if (password.isEmpty() && anyFieldInteracted) {
                        Text("This field is mandatory")
                    } else {
                        Text("Password")
                    }
                },
                placeholder = {Text("Enter your Password")},
                modifier = Modifier.padding(top=16.dp, bottom = 36.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(onClick = { val userData = UserData(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )
                userViewModel.createUser(userData)
                /*navController?.navigate(Screens.SignInScreen.route) */}) {
                Text(text = "Create your Account")
            }
        }
    }




    val createUserResult = userViewModel.createUserResult.collectAsState()
    if (createUserResult.value != null) {
        if (createUserResult.value == true) {
            // Show success message

            Toast.makeText(context, "User created successfully", Toast.LENGTH_SHORT).show()
        } else {
            // Show error message
            Toast.makeText(context, "Failed to create user", Toast.LENGTH_SHORT).show()
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewSignUpScreen(){
    //SignUpScreen()
}


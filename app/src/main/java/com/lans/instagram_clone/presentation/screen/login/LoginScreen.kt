package com.lans.instagram_clone.presentation.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lans.instagram_clone.R
import com.lans.instagram_clone.presentation.component.LoadingButton
import com.lans.instagram_clone.presentation.component.ValidableTextField
import com.lans.instagram_clone.presentation.navigation.Route
import com.lans.instagram_clone.presentation.theme.RoundedSmall
import com.lans.instagram_clone.presentation.theme.Tertiary
import com.lans.instagram_clone.presentation.theme.TertiaryVariant

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val emailUsername = state.emailUsername
    val password = state.password

    Column {
        Column(
            modifier = Modifier
                .weight(0.92f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(90.dp),
                painter = if (isSystemInDarkTheme()) {
                    painterResource(R.drawable.img_instagram_text_white)
                } else {
                    painterResource(R.drawable.img_instagram_text_black)
                },
                contentDescription = stringResource(R.string.content_description),
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            )
            ValidableTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                input = emailUsername,
                label = stringResource(R.string.email_or_username),
                onValueChange = {
                    viewModel.onEvent(LoginUIEvent.EmailUsernameChanged(emailUsername.value))
                }
            )
            ValidableTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                input = password,
                label = stringResource(R.string.password),
                onValueChange = {
                    viewModel.onEvent(LoginUIEvent.PasswordChanged(password.value))
                }
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp)
            ) {
                Text(
                    text = stringResource(R.string.forgot_your_login_details),
                    fontSize = 14.sp
                )
                Spacer(
                    modifier = Modifier
                        .width(2.dp)
                )
                Text(
                    modifier = Modifier
                        .clickable {

                        },
                    text = stringResource(R.string.get_help_logging_in),
                    color = if (isSystemInDarkTheme()) {
                        TertiaryVariant
                    } else {
                        Tertiary
                    },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            LoadingButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                text = stringResource(R.string.log_in),
                shape = RoundedSmall,
                isLoading = false,
                onClick = {

                }
            )
        }
        Column(
            modifier = Modifier
                .weight(0.08f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.dont_have_an_account),
                    fontSize = 14.sp
                )
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Route.RegisterScreen.route)
                        },
                    text = stringResource(R.string.register),
                    color = if (isSystemInDarkTheme()) {
                        TertiaryVariant
                    } else {
                        Tertiary
                    },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview() {
    LoginScreen(rememberNavController())
}
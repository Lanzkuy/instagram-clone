package com.lans.instagram_clone.presentation.screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lans.instagram_clone.R
import com.lans.instagram_clone.presentation.component.ValidableTextField
import com.lans.instagram_clone.presentation.navigation.Route

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val email = state.email
    val fullname = state.fullname
    val username = state.username
    val password = state.password

    Column {
        Column(
            modifier = Modifier
                .weight(0.92f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(90.dp),
                    painter = painterResource(R.drawable.img_instagram_text),
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
                    input = email,
                    label = stringResource(R.string.email),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.EmailChanged(email.value))
                    }
                )
                ValidableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    input = fullname,
                    label = stringResource(R.string.fullname),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.FullnameChanged(fullname.value))
                    }
                )
                ValidableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    input = username,
                    label = stringResource(R.string.username),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.UsernameChanged(username.value))
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
                        viewModel.onEvent(RegisterUIEvent.PasswordChanged(password.value))
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 24.dp, 16.dp, 16.dp),
                    shape = RoundedCornerShape(4.dp),
                    onClick = {

                    }
                ) {
                    Text(stringResource(R.string.register))
                }
                Text(
                    modifier = Modifier
                        .width(280.dp),
                    text = buildAnnotatedString {
                        append(stringResource(R.string.by_signing_up) + " ")
                        withStyle(SpanStyle(fontWeight = Bold)) {
                            append(stringResource(R.string.terms) + " ")
                            append(stringResource(R.string.data_policy) + " ")
                        }
                        append(stringResource(R.string.and) + " ")
                        withStyle(SpanStyle(fontWeight = Bold)) {
                            append(stringResource(R.string.cookies_policy))
                        }
                    },
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    maxLines = 2
                )
            }
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
                    text = stringResource(R.string.have_an_account),
                    fontSize = 14.sp
                )
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Route.LoginScreen.route)
                        },
                    text = stringResource(R.string.log_in),
                    fontSize = 14.sp,
                    fontWeight = Bold,
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
    RegisterScreen(rememberNavController())
}
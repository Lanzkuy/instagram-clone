package com.lans.instagram_clone.presentation.screen.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lans.instagram_clone.R
import com.lans.instagram_clone.presentation.component.LoadingButton
import com.lans.instagram_clone.presentation.component.ValidableTextField
import com.lans.instagram_clone.presentation.theme.RoundedSmall
import com.lans.instagram_clone.presentation.theme.Tertiary
import com.lans.instagram_clone.presentation.theme.TertiaryVariant

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    navigateToLogin: () -> Unit
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState(initial = RegisterUIState())

    LaunchedEffect(state.registerResponse) {
        val response = state.registerResponse
        val error = state.error

        if (response != null) {
            viewModel.createUser(response.uid)
        }

        if (error.isNotBlank()) {
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            state.error = ""
        }
    }

    LaunchedEffect(state.createUserResponse) {
        val response = state.createUserResponse
        val error = state.error

        if (response != null) {
            navigateToLogin.invoke()
        }

        if (error.isNotBlank()) {
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            state.error = ""
        }
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
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
                        .padding(horizontal = 16.dp),
                    input = state.email,
                    label = stringResource(R.string.email),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.EmailChanged(it))
                    }
                )
                ValidableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    input = state.fullname,
                    label = stringResource(R.string.fullname),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.FullnameChanged(it))
                    }
                )
                ValidableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    input = state.username,
                    label = stringResource(R.string.username),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.UsernameChanged(it))
                    }
                )
                ValidableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    input = state.password,
                    label = stringResource(R.string.password),
                    onValueChange = {
                        viewModel.onEvent(RegisterUIEvent.PasswordChanged(it))
                    }
                )
                LoadingButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                    text = stringResource(R.string.register),
                    shape = RoundedSmall,
                    isLoading = state.isLoading,
                    onClick = {
                        viewModel.onEvent(RegisterUIEvent.RegisterButtonClicked)
                    }
                )
                Text(
                    modifier = Modifier
                        .width(280.dp),
                    text = buildAnnotatedString {
                        append(stringResource(R.string.by_signing_up) + " ")
                        withStyle(
                            style = SpanStyle(
                                color = if (isSystemInDarkTheme()) {
                                    TertiaryVariant
                                } else {
                                    Tertiary
                                },
                                fontWeight = Bold
                            )
                        ) {
                            append(stringResource(R.string.terms) + " ")
                            append(stringResource(R.string.data_policy) + " ")
                        }
                        append(stringResource(R.string.and) + " ")
                        withStyle(
                            style = SpanStyle(
                                color = if (isSystemInDarkTheme()) {
                                    TertiaryVariant
                                } else {
                                    Tertiary
                                },
                                fontWeight = Bold
                            )
                        ) {
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
                            navigateToLogin.invoke()
                        },
                    text = stringResource(R.string.log_in),
                    color = if (isSystemInDarkTheme()) {
                        TertiaryVariant
                    } else {
                        Tertiary
                    },
                    fontSize = 14.sp,
                    fontWeight = Bold,
                )
            }
        }
    }
}
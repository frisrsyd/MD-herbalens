@file:Suppress("UNUSED_EXPRESSION")

package com.dicoding.md_herbalens.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dicoding.md_herbalens.R
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.factory.ViewModelFactory
import com.dicoding.md_herbalens.injection.RepositoryInjection
import com.dicoding.md_herbalens.ui.component.InputFields
import com.dicoding.md_herbalens.ui.navigation.Screen

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HerbalensAppViewModel = viewModel(
        factory = ViewModelFactory(RepositoryInjection.provideRepository())
    ),
) {
    Box(modifier = modifier) {
        val email by viewModel.emailValue
        val password by viewModel.passwordValue
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 32.dp)
        ){
            item{
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.herbalens_logo),
                    contentDescription = "Logo Herbalens",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }
            item {
                InputFields(
                    input = email,
                    onValueChange = { viewModel::setEmailValue },
                    textInput = "Email",
                    placeholder = "Masukkan Email"
                )
            }
            item {
                InputFields(
                    input = password,
                    onValueChange = { viewModel::setPasswordValue },
                    textInput = "Password",
                    placeholder = "Masukkan Password"
                )
            }
            item {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    onClick = { navController.navigate(Screen.Home.route) },
                    content = {
                        Text(text = "Masuk", modifier = Modifier)
                    }
                )
            }
        }
    }
}
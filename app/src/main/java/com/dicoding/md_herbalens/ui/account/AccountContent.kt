package com.dicoding.md_herbalens.ui.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dicoding.md_herbalens.R

@Composable
fun AccountContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Column(modifier = modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.herbalens_logo),
                contentDescription = "Logo Herbalens",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            onClick = { navController.navigate("login") },
            content = {
                Text(text = "Masuk", modifier = Modifier)
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            onClick = { navController.navigate("register") },
            content = {
                Text(text = "Daftar", modifier = Modifier)
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            onClick = {  },
            content = {
                Text(text = "Keluar", modifier = Modifier)
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewAccountContent() {
    AccountContent(
        modifier = Modifier,
        navController = NavHostController(LocalContext.current)
    )
}
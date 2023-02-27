package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.mohammad.askar.roomcleanarchitcture.R
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.Screen
import com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home.component.UserItem
import com.mohammad.askar.roomcleanarchitcture.ui.theme.*

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val homeState = homeViewModel.homeState.collectAsState()
    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            HomeFab(onFabClicked = { navController.navigate(Screen.Edit.route) })
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(paddingValues = innerPadding),
                onDeleteUser = { homeViewModel.onEvent(HomeEvent.DeleteUser(user = it)) },
                onEditUser = {
                    navController.navigate(Screen.Edit.passId(userId = it))
                },
                users = homeState.value.users
            )
        },
    )
}

@Composable
fun HomeContent(
    modifier: Modifier,
    onDeleteUser: (user: User) -> Unit,
    onEditUser: (id: Int?) -> Unit,
    users: List<User> = emptyList()
) {
    Surface(
        modifier = modifier,
    ) {
        LazyColumn {
            items(items = users) { user ->
                UserItem(
                    user = user,
                    onEditUser = { onEditUser(user.id) },
                    onDeleteUser = { onDeleteUser(user) }
                )
            }
        }
    }

}

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.users),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color = Color.Black,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = { onFabClicked },
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = stringResource(id = R.string.add_user)
        )
    }
}
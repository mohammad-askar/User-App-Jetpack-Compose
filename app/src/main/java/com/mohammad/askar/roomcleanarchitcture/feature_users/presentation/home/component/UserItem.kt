package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User


@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    user: User,
    onEditUser: () -> Unit,
    onDeleteUser: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        elevation = 8.dp,
        shape = RoundedCornerShape(
            corner = CornerSize(size = 16.dp)
        )
    ) {
        Row(
            modifier = Modifier.background(Color.White).padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    fontFamily = FontFamily.Monospace,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = "${user.name} ${user.lastName} ",
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = user.age.toString(),
                    style = MaterialTheme.typography.caption.copy(Color.DarkGray),
                    fontSize = 18.sp
                )
            }
            Row {
                IconButton(
                    onClick = { onEditUser }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit User",
                        tint = Color.Green
                    )
                }

                IconButton(
                    onClick = { onDeleteUser }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete User",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}
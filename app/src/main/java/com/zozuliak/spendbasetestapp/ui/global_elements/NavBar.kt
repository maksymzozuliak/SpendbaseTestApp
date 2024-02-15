package com.zozuliak.spendbasetestapp.ui.global_elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.ui.theme.Blue500
import com.zozuliak.spendbasetestapp.ui.theme.Neutral0
import com.zozuliak.spendbasetestapp.ui.theme.Neutral400
import com.zozuliak.spendbasetestapp.ui.theme.StrokeGrey

@Composable
fun NavBar() {

    data class NavBarItemData(
        val text: String,
        @DrawableRes val icon: Int
    )

    val items = listOf(
        NavBarItemData("Home", R.drawable.ic_home),
        NavBarItemData("Transactions", R.drawable.ic_list),
        NavBarItemData("My Cards", R.drawable.ic_credit_card),
        NavBarItemData("Account", R.drawable.ic_user),
    )


    Column() {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = StrokeGrey
        )
        NavigationBar(
            containerColor = Color.White
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            modifier = Modifier,
                            painter = painterResource(item.icon),
                            contentDescription = item.text
                        )
                    },
                    label = {
                        Text(
                            modifier = Modifier,
                            text = item.text,
                            style = TextStyle(
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 10.sp
                            ),
                        )
                    },
                    selected = index == 0,
                    onClick = { },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Blue500,
                        selectedTextColor = Blue500,
                        indicatorColor = Color.White,
                        unselectedIconColor = Neutral400,
                        unselectedTextColor = Neutral400
                    )
                )
            }
        }
    }
}
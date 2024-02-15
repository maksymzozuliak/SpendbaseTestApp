package com.zozuliak.spendbasetestapp.ui.main_screen.elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.ui.global_elements.SeeAllButton

@Composable
fun MyCardsItem(
    modifier: Modifier = Modifier,
    label: String,
    labelTextStyle: TextStyle = MaterialTheme.typography.labelMedium,
    cards: List<Card>,
    onCardItemClick: (Card) -> Unit
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier.padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = label,
                    style = labelTextStyle
                )
                Spacer(modifier = Modifier.weight(1f))
                SeeAllButton(onClick = { })
            }
            LazyColumn(
                modifier = Modifier
            ) {

                items(
                    items = cards,
                    key = { card ->
                        card.hashCode()
                    }
                ) {  card ->

                    CardItem(
                        card = card
                    ) {
                        onCardItemClick(card)
                    }
                }
            }
        }
    }
}
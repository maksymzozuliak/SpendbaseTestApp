package com.zozuliak.spendbasetestapp.ui.card_screen.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zozuliak.spendbasetestapp.R

@Composable
fun CardButtonsPanel(
    modifier: Modifier = Modifier
) {
    
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            VerticalIconTextButton(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_eye,
                text = "Details",
                onClick = {  }
            )
            Spacer(modifier = Modifier.width(8.dp))
            VerticalIconTextButton(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_lock,
                text = "Lock",
                onClick = {  }
            )
            Spacer(modifier = Modifier.width(8.dp))
            VerticalIconTextButton(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_credit_card_close,
                text = "Terminate",
                onClick = {  }
            )
        }
    }
}
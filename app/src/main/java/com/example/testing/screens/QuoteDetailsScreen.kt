package com.example.testing.screens

import Quote
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testing.DataManager


@Composable
fun QuoteDetails(quote: Quote) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.White, Color.Gray
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(

            modifier = Modifier.padding(32.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
                    .align(Alignment.CenterHorizontally)


            ) {
                Image(
                    imageVector = Icons.Filled.Edit, contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = quote.quote,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = quote.author,
                    fontFamily = FontFamily.Cursive,
                    style = MaterialTheme.typography.bodySmall
                )


            }

        }

    }

}



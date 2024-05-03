package com.example.testing.screens

import Quote
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuoteListItem(quote = it,onClick)
        }
    })


}
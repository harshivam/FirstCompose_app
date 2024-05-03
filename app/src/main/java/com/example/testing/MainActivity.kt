package com.example.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.testing.screens.QuoteDetails
import com.example.testing.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            App()

        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value==Pages.LISTING){
        QuoteListScreen(data = DataManager.data) {
            DataManager.switchPages(it)

        }}else{
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    }
    else{
        Text(text = "Loading",
            style = MaterialTheme.typography.bodyMedium)
    }

}
enum class Pages{
    LISTING,
    DETAILS
}




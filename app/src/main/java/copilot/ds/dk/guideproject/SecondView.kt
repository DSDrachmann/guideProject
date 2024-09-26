package copilot.ds.dk.guideproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

class SecondView() {

    @Composable
    fun InputView(
        modifier: Modifier,
        navController: NavHostController,
        callback: (result1: String, result2: String) -> Unit
    ) {
        var text by rememberSaveable { mutableStateOf("") }

        Column {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = modifier.fillMaxWidth(),
                label = { Text("Enter text") }
            )
            Button(onClick = { navController.navigate("mainView") }) {
                Text(text = "Go to Main View")
            }
            Button(onClick = { callback("Result 1", "Result 2") }) {
                Text(text = "go back with data")
            }
        }
    }
}
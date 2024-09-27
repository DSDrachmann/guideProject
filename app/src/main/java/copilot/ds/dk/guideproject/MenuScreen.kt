package copilot.ds.dk.guideproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import copilot.ds.dk.guideproject.ui.theme.DarkGreen

@Composable
fun MenuScreen(navController: NavHostController, day: String) {
    val menuOptions = listOf("pizza", "taco")

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Vælg hvilken ret du ønsker til din frokost",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(textAlign = TextAlign.Center, text = "Menu for $day", modifier = Modifier.padding(bottom = 16.dp))

        menuOptions.forEach { dish ->
            Button(
                onClick = { navController.navigate("dishDetail/$dish") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),colors = ButtonDefaults.buttonColors(
                    containerColor = DarkGreen,
                    contentColor = Color.White
                ),
            ) {
                Text(text = dish)
            }
        }

        Button(
            onClick = { navController.navigateUp() },
            modifier = Modifier.padding(top = 16.dp),colors = ButtonDefaults.buttonColors(
                containerColor = DarkGreen,
                contentColor = Color.White
            ),
        ) {
            Text(text = "Back")
        }
    }
}
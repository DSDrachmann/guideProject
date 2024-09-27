package copilot.ds.dk.guideproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.*


class ThirdView {
    @Composable
    fun ComposableView(callback: () -> Unit) {
        RockPaperScissorsGame(callback)
    }

    @Composable
    fun RockPaperScissorsGame(callback: () -> Unit) {
        var result by remember { mutableStateOf("Make your move!") }
        val choices = listOf("Rock", "Paper", "Scissors")
        var playerChoice by remember { mutableStateOf<String?>(null) }
        var computerChoice by remember { mutableStateOf<String?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Rock-Paper-Scissors", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Player's Choice: ${playerChoice ?: "None"}", fontSize = 18.sp)
            Text(text = "Computer's Choice: ${computerChoice ?: "None"}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                choices.forEach { choice ->
                    Text(
                        text = choice,
                        modifier = Modifier
                            .background(color = Color.Gray)
                            .padding(16.dp)
                            .clickable {
                                playerChoice = choice
                                computerChoice = choices.random()
                                result = determineWinner(playerChoice, computerChoice)
                            }
                    )
                }
            }


            Spacer(modifier = Modifier.height(32.dp))
            Text(text = result, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { callback.invoke() }) {
                Text(text = "Back to Main View")
            }
        }
    }

    private fun determineWinner(playerChoice: String?, computerChoice: String?): String {
        if (playerChoice == computerChoice) {
            return "It's a tie!"
        }

        return when (playerChoice) {
            "Rock" -> if (computerChoice == "Scissors") "You win!" else "You lose!"
            "Paper" -> if (computerChoice == "Rock") "You win!" else "You lose!"
            "Scissors" -> if (computerChoice == "Paper") "You win!" else "You lose!"
            else -> "Invalid choice"
        }
    }
}
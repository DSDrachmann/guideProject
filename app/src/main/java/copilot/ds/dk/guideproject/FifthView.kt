package copilot.ds.dk.guideproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FifthView {
    @Composable
    fun ComposableView(callback: () -> Unit) {
        LotteryGameUI(callback)
    }

    @Composable
    fun LotteryGameUI(callback: () -> Unit) {
        val maxNumber = 49
        val numbersToPick = 6
        var userChoices = remember { mutableStateListOf<Int>() }
        var drawNumbers by remember { mutableStateOf<List<Int>>(emptyList()) }
        var result by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Lottery Game", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Pick $numbersToPick numbers:")
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                for (i in 1..maxNumber) {
                    Text(
                        text = "$i",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(4.dp)
                            .background(
                                if (userChoices.contains(i)) Color.Green else Color.Gray,
                                shape = MaterialTheme.shapes.medium
                            )
                            .clickable {
                                if (userChoices.contains(i)) {
                                    userChoices.remove(i)
                                } else if (userChoices.size < numbersToPick) {
                                    userChoices.add(i)
                                }
                            }
                            .padding(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (userChoices.size == numbersToPick) {
                        drawNumbers = (1..maxNumber).shuffled().take(numbersToPick)
                        result = "You matched ${userChoices.intersect(drawNumbers).size} numbers!"
                    } else {
                        result = "Please pick $numbersToPick numbers."
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Draw Numbers")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Your picks: ${userChoices.sorted()}")
            Text(text = "Drawn numbers: ${drawNumbers.sorted()}")
            Text(text = result, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { callback.invoke() }) {
                Text(text = "Back to Main View")
            }
        }
    }
}
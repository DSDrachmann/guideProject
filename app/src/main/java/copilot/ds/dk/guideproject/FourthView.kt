package copilot.ds.dk.guideproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FourthView {
    @Composable
    fun ComposableView(callback: () -> Unit) {
        CalculatorUI(callback)
    }

    @Composable
    fun CalculatorUI(callback: () -> Unit) {
        var currentInput by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Calculator", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = if (currentInput.isEmpty()) "0" else currentInput,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = result, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(32.dp))

            val buttons = listOf(
                "7", "8", "9", "C",
                "4", "5", "6", "/",
                "1", "2", "3", "*",
                ".", "0", "=", "+"
            )

            for (i in buttons.indices step 4) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (j in 0 until 4) {
                        val button = buttons[i + j]
                        Button(
                            onClick = {
                                when (button) {
                                    "C" -> {
                                        currentInput = ""
                                        result = ""
                                    }
                                    "=" -> {
                                        try {
                                            val evalResult = evaluateExpression(currentInput)
                                            result = "= $evalResult"
                                        } catch (e: Exception) {
                                            result = "Error"
                                        }
                                    }
                                    else -> currentInput += button
                                }
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        ) {
                            Text(text = button, fontSize = 24.sp)
                        }
                    }
                }
            }

            val extraRow = listOf("-", "=")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                extraRow.forEach { button ->
                    Button(
                        onClick = {
                            if (button == "=") {
                                try {
                                    val evalResult = evaluateExpression(currentInput)
                                    result = "= $evalResult"
                                } catch (e: Exception) {
                                    result = "Error"
                                }
                            } else {
                                currentInput += button
                            }
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                    ) {
                        Text(text = button, fontSize = 24.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { callback.invoke() }) {
                Text(text = "Back to Main View")
            }
        }
    }

    fun evaluateExpression(expression: String): Double {
        // Implement a simple parser to evaluate the expression
        // This function assumes the input expression is always valid
        return object {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < expression.length) expression[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < expression.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.code)) x += parseTerm() // addition
                    else if (eat('-'.code)) x -= parseTerm() // subtraction
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.code)) x *= parseFactor() // multiplication
                    else if (eat('/'.code)) x /= parseFactor() // division
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor() // unary plus
                if (eat('-'.code)) return -parseFactor() // unary minus

                var x: Double
                val startPos = this.pos
                if (eat('('.code)) { // parentheses
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) { // numbers
                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    x = expression.substring(startPos, this.pos).toDouble()
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }

                return x
            }
        }.parse()
    }
}
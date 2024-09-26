package copilot.ds.dk.guideproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

//TODO: 0 - find out why the app view is all moved to the left. (In MainView.kt)
//TODO: 1 - find out why the buttons are not aligned horizontally (In MainView.kt)
//TODO: 2 - place a box above these buttons with a text "Welcome to the app" (In MainView.kt)
//TODO: 3 - make both the buttons and the box align in the center of the screen. (In MainView.kt)
//TODO: 4 - create a button that switches the colors of the two buttons. (In MainView.kt)

class MainView() {

    @Composable
    fun ComposableView(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally, //REMOVE THIS
                    verticalArrangement = Arrangement.Center //REMOVE THIS
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Welcome to the Main View")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val leftButtonColor = remember { mutableStateOf(Color.Gray) }
                val rightButtonColor = remember { mutableStateOf(Color.Gray) }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    ) {
                    Row {
                        Button(onClick = {
                            leftButtonColor.value =
                                if (leftButtonColor.value == Color.Gray) Color.Red else Color.Gray
                        },
                            colors = ButtonDefaults.buttonColors(containerColor = leftButtonColor.value),
                            content = {
                                Text(text = "Click me")
                            }
                        )
                        Button(onClick = {
                            rightButtonColor.value =
                                if (rightButtonColor.value == Color.Gray) Color.Green else Color.Gray
                        },
                            colors = ButtonDefaults.buttonColors(containerColor = rightButtonColor.value),
                            modifier = Modifier.padding(start = 16.dp),
                            content = {
                                Text(text = "Click me")
                            }
                        )
                    }
                    Row {
                        Button(onClick = {
                            val tempColor = leftButtonColor.value
                            leftButtonColor.value = rightButtonColor.value
                            rightButtonColor.value = tempColor
                        },
                            modifier = Modifier.padding(top = 16.dp)
                                .align(Alignment.CenterVertically),
                            content = {
                                Text(text = "Switch Colors")
                            }
                        )
                    }
                }
            }
            Button(onClick = {
                navController.navigate("secondView")
            },
                modifier = Modifier.padding(top = 16.dp),
                content = {
                    Text(text = "Go to Second View")
                }
            )
        }
    }
}
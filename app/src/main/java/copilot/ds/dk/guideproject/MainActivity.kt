package copilot.ds.dk.guideproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import copilot.ds.dk.guideproject.ui.theme.GuideProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuideProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.width(100.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "mainView") {
        composable(route = "mainView") { MainView().ComposableView(navController) }
        composable("secondView") {
            SecondView().InputView(
                Modifier, navController,
                callback = { result1, result2 ->
                    navController.navigate("mainView") }
            )
        }
    }
}

//TODO: Here are some additional things you can try with github copilot.
//TODO: Animation - Use Copilot to add a simple animation when navigating between views.
//TODO: Animation - Add an animation to the buttons that changes their size when clicked.


//TODO: Use copilot to make a cache for some data
//TODO: Use Copilot to make a database using room


//TODO: Now that you have gone through all this, try to make a simple app that does rock paper sciccors.
//TODO: Now that you have gone through all this, try to make a simple app that works as a color picker
//TODO: Now that you have gone through all this, try to make a simple app that works as a calculator
//TODO: Now that you have gone through all this, try to make a simple app that works as a todo list
//TODO: Now that you have gone through all this, try to make a simple app that works as a random quote generator
//TODO: Now that you have gone through all this, where you can gamble with fake money


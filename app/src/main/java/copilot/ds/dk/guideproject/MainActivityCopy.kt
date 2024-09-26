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

//TODO: Try to use copilot to do the following:
//TODO: 3 - make both the buttons and the box align in the center of the screen.
//TODO: 4 - create a button that switches the colors of the two buttons.
//TODO: 5 - create a navController navigation component in the MainActivity, it needs to navigate to the MainView initially.
//TODO: 5.1 - HINT: the navigation component should be a NavHost.
//TODO: 5.2 - HINT: the NavHost should have a startDestination of "mainView".
//TODO: 6 - create a button that will change to the second view.
//TODO: 7 - In the second view, make a input field and a button that will navigate back to the main view.
//TODO: 8 - get copilot to save the state of the text field in the second view. ((to save the state means to save the text that is in the text field when doing other stuff in the same view))
//TODO: 8.1 - HINT: it has something to do with rememberSaveable.
//TODO: 9 - If you haven't discovered already, the second view is not saving the state of the text field when navigating back and forth between the views. Try to ask copilot why this is happening and how to fix it.
//TODO: 9.1 - HINT: is has something to do with a shared ViewModel.
//TODO: start up the spring boot project called Demo Api
//TODO: use copilot to create a Get call that you can call from this android app
//TODO: Start it up by writing the following command in the terminal: ./gradlew bootRun
//TODO: GO back to this project
//TODO: Connect to the springboot API using retrofit and get the greeting message from the spring boot project.
//TODO: Create a text field that can be filled with that data.

class MainActivityCopy : ComponentActivity() {
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
fun AppNavHostCopy(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "mainView") {
        composable(route = "mainView") { MainView().ComposableView(navController) }
        composable("secondView") {
            SecondView().InputView(Modifier, navController, callback = { result1, result2 ->
                println("Result 1: $result1, Result 2: $result2")
            })
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


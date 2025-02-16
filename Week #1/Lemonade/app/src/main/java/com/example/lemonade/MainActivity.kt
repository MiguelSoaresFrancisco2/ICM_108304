package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}




@Composable
fun LemonadeApp() {
    var step by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var squeezeTarget by remember { mutableStateOf((2..4).random()) }

    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when (step) {  
    
    
        1 -> R.string.lemon_tree
        
        2 -> R.string.squeeze_lemon
        3 -> R.string.drink_lemonade
        else -> R.string.restart
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
    
    
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = textResource),
            modifier = Modifier
                .clickable {
                    when (step) {
                        1 -> {
                            step = 2
                            squeezeTarget = (2..4).random() 
                            squeezeCount = 0
                        }
                        2 -> {
                            squeezeCount++
                            if (squeezeCount >= squeezeTarget) {
                                step = 3
                            }
                        }
                        3 -> step = 4
                        4 -> step = 1
                    }
                }
        )
        
        
        Spacer(modifier = Modifier.height(16.dp))
        
        
        
        Text(text = stringResource(id = textResource))
    }
}

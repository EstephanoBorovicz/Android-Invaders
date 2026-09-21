package com.example.android_invaders
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_invaders.ui.theme.Android_invadersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_invadersTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaStart(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.Black)
                    )
                }
            }
        }
    }
}

@Composable
fun TelaStart(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
//                .weight(1f),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "SCORE: 0050",
                    color = Color.White,
                )
            }
            Column(
                modifier = Modifier
//                    .weight(2f),
//                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "LIVES: ",
                        color = Color.White
                    )
                    for (i in 1..3) {
                        SpaceInvader(
                            modifier = Modifier
                                .size(30.dp),
                            color = Color.Green
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier

                .weight(2f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            val cores = listOf(
                Color.Green, Color.Red, Color.Blue, Color.Yellow
            )

            for (cor in cores){
                SpaceInvader(
                    modifier = Modifier
                        .size(90.dp),
                    color = cor
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SpaceInvader(
                modifier = Modifier
                    .size(90.dp),
                color = Color.Green
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray),
                horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "PRESS START",
                color = Color.White,

            )
        }
    }
}

@Composable
fun SpaceInvader(color: Color,
                 modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color=color),
        contentDescription = "space invader"
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_invadersTheme {
        TelaStart(modifier = Modifier)
    }
}
package com.example.lemonde

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonde.ui.theme.LemondeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemondeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    lemonadeAap()
                }
            }
        }
    }
}

@Composable
fun lemonadeMaking(modifier: Modifier) {
    var state by remember { mutableStateOf(1) }
    var squeez by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (state) {
            1 -> {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(R.string.lemonade_tree))
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                state = 2
                                squeez = (2..4).random()

                            }
                    )

                }
            }
            2 -> {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(text = stringResource(R.string.squeezing))
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                            squeez--
                                if(squeez==0) {
                                    state = 3
                                }
                            }
                    )
                }
            }
            3 -> {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(text = stringResource(R.string.Drink))
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                state = 4
                            }
                    )
                }
            }
            4 -> {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(text = stringResource(R.string.empty_glass))
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = null,
                                modifier = Modifier
                                .wrapContentSize()
                            .clickable {
                                state = 1
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun lemonadeAap() {
    LemondeTheme {
        lemonadeMaking(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}
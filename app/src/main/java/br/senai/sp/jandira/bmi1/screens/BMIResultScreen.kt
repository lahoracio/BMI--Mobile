package br.senai.sp.jandira.bmi1.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi1.R

@Composable
fun BMIResultScreen(controleDeNavegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)

    val nomeAge = userFile.getInt("user_age", 0)
    val nomeWeight= userFile.getInt("user_weight", 0)
    val nomeHeight= userFile.getInt("user_height", 0)


    var nomeState = remember {
        mutableStateOf(value = "")
    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Magenta,
                        Color.Blue
                    )
                )
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = stringResource(R.string.Result),
                fontSize = 27.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(30.dp)
                    .weight(1f)
            )
            Card(
                modifier = Modifier

                    .fillMaxSize()
                    .height(150.dp)
                    .weight(9f),
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 38.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )

            ) {

                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight (1.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            modifier = Modifier
                                .size(120.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 5.dp,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color.Magenta,
                                        Color.Blue
                                    )
                                )
                            )
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = stringResource(R.string.Peso1),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                )

                            }
                        }

                        Text(
                            text = stringResource(R.string.Obesity),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(15.dp)
                        )

                        Card(
                            modifier = Modifier
                                .height(90.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {
                                    Text(
                                        text = stringResource(R.string.Age)
                                    )
                                    Text(
                                        text = "$nomeAge",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                }
                                VerticalDivider()
                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.Weight)
                                    )
                                    Text(
                                        text = "$nomeWeight",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                }
                                VerticalDivider()
                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.High)
                                    )
                                    Text(
                                        text = "$nomeHeight cm",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                }

                            }




                         }
                    }

                    Box(
                        modifier = Modifier
                            .weight(0.9f)
                            .fillMaxSize()
                            .background(Color.Magenta)
                            .padding(horizontal = 20.dp)
                    ) {

                    }

                    Column(
                        modifier = Modifier
                            .weight(0.7f)
                    ) {
                        Button(
                            onClick = {
                                controleDeNavegacao?.navigate(route = "user_data")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp)
                                .height(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue
                            )


                        ) {
                            Text(

                                text = stringResource(R.string.New_Calc),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,


                            )
                        }
                    }

                        }
                    }

                }

            }

        }











@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi1.R
import br.senai.sp.jandira.bmi1.model.BmiStatus
import br.senai.sp.jandira.bmi1.model.bmiCalculator
import br.senai.sp.jandira.bmi1.screens.components.BmiLevels
import java.util.Locale

@Composable
fun BMIResultScreen(controleDeNavegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)

    val nomeAge = userFile.getInt("user_age", 0)
    val nomeWeight= userFile.getInt("user_weight", 0)
    val nomeHeight= userFile.getInt("user_height", 0)






    var resultbmi = bmiCalculator(nomeWeight, nomeHeight.toDouble())

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
                                color = resultbmi.color
                            )
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.White)
                            ) {

                                val bmiValue = resultbmi.bmiValues.second
                                Text(
                                    text = String.format(Locale.getDefault(), "%.1f", bmiValue),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                )

                            }
                        }

                        Text(
                            text = resultbmi.bmiValues.first,
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
                            .background(Color.Transparent)
                            .padding(horizontal = 20.dp)
                    ) {
                        Column (
                            modifier = Modifier
                                .padding(top = 16.dp, bottom = 16.dp)
                                .fillMaxWidth()
                        ){
                            BmiLevels(
                                leftText = stringResource(R.string.underweight),
                                rightText = "< " + String.format(Locale.getDefault(), "%.1f", 18.5),
                                bulletBackground = colorResource(R.color.light_blue),
                                background = if (resultbmi.status == BmiStatus.UNDER_WEIGHT) colorResource(R.color.light_blue) else Color.Transparent
                            )
                            BmiLevels(
                                leftText = stringResource(R.string.normal),
                                rightText = String.format(Locale.getDefault(), "%.1f", 18.6) + " - " + String.format(Locale.getDefault(), "%.1f", 24.9),
                                bulletBackground = colorResource(R.color.light_green),
                                background = if (resultbmi.status == BmiStatus.NORMAL) colorResource(R.color.light_green) else Color.Transparent
                            )
                            BmiLevels(
                                leftText = stringResource(R.string.overweight),
                                rightText = String.format(Locale.getDefault(), "%.1f", 25.0) + " - " + String.format(Locale.getDefault(), "%.1f", 29.9),
                                bulletBackground = colorResource(R.color.yellow),
                                background = if (resultbmi.status == BmiStatus.OVER_WEIGHT) colorResource(R.color.yellow) else Color.Transparent
                            )
                            BmiLevels(
                                leftText = stringResource(R.string.obesity1),
                                rightText = String.format(Locale.getDefault(), "%.1f", 30.0) + " - " + String.format(Locale.getDefault(), "%.1f", 34.9),
                                bulletBackground = colorResource(R.color.light_orange),
                                background = if (resultbmi.status == BmiStatus.OBESITY_1) colorResource(R.color.light_orange) else Color.Transparent
                            )
                            BmiLevels(
                                leftText = stringResource(R.string.obesity2),
                                rightText = String.format(Locale.getDefault(), "%.1f", 35.0) + " - " + String.format(Locale.getDefault(), "%.1f", 39.9),
                                bulletBackground = colorResource(R.color.dark_orange),
                                background = if (resultbmi.status == BmiStatus.OBESITY_2) colorResource(R.color.dark_orange) else Color.Transparent
                            )
                            BmiLevels(
                                leftText = stringResource(R.string.obesity3),
                                rightText = "> " + String.format(Locale.getDefault(), "%.1f", 40.0),
                                bulletBackground = colorResource(R.color.red),
                                background = if (resultbmi.status == BmiStatus.OBESITY_3) colorResource(R.color.red) else Color.Transparent

                            )

                        }
                    }

                    Column(
                        modifier = Modifier
                            .weight(0.7f)
                    ) {
                        HorizontalDivider()
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
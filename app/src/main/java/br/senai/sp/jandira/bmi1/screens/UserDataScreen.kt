package br.senai.sp.jandira.bmi1.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi1.R

@Composable
fun UserDataScreen(controleDeNavegacao: NavHostController?) {

    //Obtendo o contexto da tela atual
    val context = LocalContext.current

    //Abrir ou criar um arquivo SharedPreferences
    val userFile =  context
        .getSharedPreferences(
            "user_file", Context.MODE_PRIVATE
        )

    //criamos ou editar responsavel por editar arquivo
    val editor = userFile.edit()
    val userName = userFile.getString("user_name", "user not found")


    val nomeState = remember {mutableStateOf(value = "")}
    val nomeAge = remember {mutableStateOf(value = "")}
    val nomeWeight= remember {mutableStateOf(value = "")}
    val nomeHeight = remember {mutableStateOf(value = "")}

    val selectColorState = remember { mutableStateOf(Color.Blue)}
    val unselectColorState = remember { mutableStateOf(Color.LightGray)}

    val isMaleOnClicked = remember { mutableStateOf(false) }
    val isFemaleOnClicked = remember { mutableStateOf(false) }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = "${stringResource(R.string.Hi)}, $userName!",
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
                        .padding(30.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Row (
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card (
                                modifier = Modifier
                                    .size(120.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color.Magenta,
                                            Color.Blue
                                        )
                                    )
                                )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.homem),
                                    contentDescription = "",
                                    modifier = Modifier


                                )
                            }

                            Button(
                                onClick = {
                                    isMaleOnClicked.value = true
                                    isFemaleOnClicked.value = false
                                },
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isMaleOnClicked.value) selectColorState.value else unselectColorState.value
                                    )

                            )
                            {
                                Text(text = stringResource(R.string.Male))
                            }
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card (
                                modifier = Modifier
                                    .size(120.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color.Magenta,
                                            Color.Blue
                                        )
                                    )
                                )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.mulher),
                                    contentDescription = "",
                                    modifier = Modifier


                                )
                            }

                            Button(
                                onClick = {
                                    isMaleOnClicked.value = false
                                    isFemaleOnClicked.value = true
                                },
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isFemaleOnClicked.value) selectColorState.value else unselectColorState.value
                                )
                            )
                            {
                                Text(text = stringResource(R.string.Female))
                            }
                        }
                    }

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    {
                        OutlinedTextField(
                            value = nomeAge.value,
                            onValueChange = {
                                nomeAge.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.Age)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color.Magenta

                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )

                        )
                        OutlinedTextField(
                            value = nomeWeight.value,
                            onValueChange = {
                                nomeWeight.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.Weight)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color.Magenta

                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )

                        )
                        OutlinedTextField(
                            value = nomeHeight.value,
                            onValueChange = {
                                nomeHeight.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.Height)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color.Magenta

                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )

                        )
                    }

                    Button(
                        onClick = {
                            editor.putInt("user_age", nomeAge.value.toInt())
                            editor.putInt("user_height", nomeHeight.value.toInt())
                            editor.putInt("user_weight", nomeHeight.value.toInt())
                            editor.apply()
                            controleDeNavegacao?.navigate(route = "bmi_result")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.Calculate)
                        )
                    }

                }

            }

        }
    }

}








@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen(null)
}
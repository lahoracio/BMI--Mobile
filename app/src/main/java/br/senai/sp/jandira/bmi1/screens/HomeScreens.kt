package br.senai.sp.jandira.bmi1.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi1.R

@Composable
fun HomeScreen(controleDeNavegacao: NavHostController?) {

    var context = LocalContext.current

    var nomeState = remember {
        mutableStateOf(value = "")

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color.Blue, Color.Magenta)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(R.drawable.atleta),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier
                    .padding(vertical = 60.dp)

            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 60.dp)


            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .height(150.dp),
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 48.dp
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)

                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .padding(start = 30.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 16.sp,
                            color = Color.White,
                        )
                        //Para adicionar os icones dentro da caixa de texto
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = { it ->
                                nomeState.value = it
                            },
                            label = {
                                Text(text = "Digite o seu nome.")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            //leading é começo e trainibng é fim
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "",
                                    tint = Color.Magenta
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = Color.Blue
                                )
                            },
                            //definir o teclado- Deixando o começo com letra maiuscula sempre no inicio da frase (so trocar o keyBoardType)
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Sentences
                            )
                        )
                        Button(
                            onClick = {
                                controleDeNavegacao?.navigate("user_data")
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .padding(top = 230.dp)
                                .padding(start = 200.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.next),
                                fontSize = 20.sp
                            )
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = "colocar icone-seta"
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
private fun HomeScreenPreview() {
    HomeScreen(null)
}

package br.senai.sp.jandira.bmi1.model

import androidx.compose.ui.graphics.Color

data class Bmi(
    var color: Color = Color.Transparent,
    var status: BmiStatus = BmiStatus.NORMAL,
    var bmiValues: Pair<String, Double> = Pair("", 0.0)
)


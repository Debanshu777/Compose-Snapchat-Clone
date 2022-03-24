package com.debanshu777.snapchatUIComposeClone.features.feature_authentication.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors

@Preview
@Composable
fun CustomButton(
    onClick: () -> Unit ={}
){
    Button(
        modifier= Modifier
            .width(200.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = ThemeColors.BLUE),
        elevation= ButtonDefaults.elevation(
            defaultElevation = 40.dp,
            pressedElevation = 0.dp,
            disabledElevation = 40.dp
        ),
        onClick = onClick) {
        Text(text = "Log In",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color= Color.White,
            fontSize = 20.sp
        )
    }
}
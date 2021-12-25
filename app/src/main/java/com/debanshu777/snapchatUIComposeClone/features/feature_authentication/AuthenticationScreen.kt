package com.debanshu777.snapchatUIComposeClone.features.feature_authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_authentication.presentation.components.CustomButton


@ExperimentalUnitApi
@Preview
@Composable
fun AuthenticationView(){
    Column(
        modifier = Modifier
            .background(ThemeColors.YELLOW)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(100.dp)
                .width(50.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(R.drawable.snapchat_splash_logo),
                contentDescription ="snapchat_logo" )
        Image(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .clip(CircleShape)
                .background(ThemeColors.LIGHT_ICON_TINT)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(R.drawable.bitmoji), contentDescription ="user_bitmoji" )
        Text(text = "thedebanshu", fontWeight = FontWeight.Medium)
        Text(text = "Remove account", color=ThemeColors.BLUE ,fontSize = 9.sp)
        CustomButton()
        BottomSwitch()
    }
}

@Composable
fun BottomSwitch(){
    Row(
        modifier=Modifier.fillMaxWidth().padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier=Modifier.padding(20.dp).weight(0.5f),
            text = "Sign Up",
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        Divider(
            modifier = Modifier
                .background(color = ThemeColors.LIGHTER_ICON_TINT)
                .height(40.dp)
                .width(1.dp),
        )
        Text(
            modifier=Modifier.padding(20.dp).weight(0.5f),
            text = "Switch Account",
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}
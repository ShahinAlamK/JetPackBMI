package com.example.bmi.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.bmi.ui.theme.GrayLight


@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    onClick:()->Unit,
    label: String,
    icon: Painter
){
    Box(
        modifier = modifier.clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Icon(
                modifier = Modifier.size(45.dp),
                tint = GrayLight,
                painter = icon,
                contentDescription ="" )
            Text(text = label,
                color = GrayLight,
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}
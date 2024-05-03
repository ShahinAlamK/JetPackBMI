package com.example.bmi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bmi.R
import com.example.bmi.ui.theme.GrayLight

@Composable
fun BottomCard(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    increment:()->Unit,
    decrement:()->Unit,
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = GrayLight
            )

            Text(text = value,
                style = MaterialTheme.typography.titleLarge,
                color = GrayLight
            )

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(GrayLight, shape = CircleShape)
                        .clickable { decrement() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(40.dp).padding(15.dp),
                        painter = painterResource(id = R.drawable.minus), contentDescription ="" )
                }


                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(GrayLight, shape = CircleShape)
                        .clickable { increment() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(40.dp).padding(15.dp),
                        painter = painterResource(id = R.drawable.plus), contentDescription ="" )
                }

            }
        }
    }
}
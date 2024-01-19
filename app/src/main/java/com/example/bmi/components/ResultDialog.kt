package com.example.bmi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi.ResultModel
import com.example.bmi.ui.theme.GrayLight
import com.example.bmi.ui.theme.Pink
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultDialog(isOpen: MutableState<Boolean>,result: ResultModel){
    if (isOpen.value){
        AlertDialog(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .background(GrayLight, shape = RoundedCornerShape(10.dp)),
            onDismissRequest = { }) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "Your Result", style = MaterialTheme.typography.bodyMedium)
                Divider()

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = result.result.roundToInt().toString(),
                    fontSize = 32.sp,style = MaterialTheme.typography.titleMedium)
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = result.type,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Pink))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Gender: ${result.gender}", style = MaterialTheme.typography.labelSmall)
                    Text(text = "Weight: ${result.weight} KG", style = MaterialTheme.typography.labelSmall)
                    Text(text = "Height: ${result.height}.${result.inch} inch", style = MaterialTheme.typography.labelSmall)
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Pink
                    ),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { isOpen.value=false}) {
                    Text(text = "Re-Calculate",style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
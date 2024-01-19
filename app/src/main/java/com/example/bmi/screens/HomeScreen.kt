package com.example.bmi.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bmi.BmiViewModel
import com.example.bmi.R
import com.example.bmi.ResultModel
import com.example.bmi.components.BottomCard
import com.example.bmi.components.CustomCard
import com.example.bmi.components.ResultDialog
import com.example.bmi.ui.theme.BlueDark
import com.example.bmi.ui.theme.BlueLight
import com.example.bmi.ui.theme.GrayLight
import com.example.bmi.ui.theme.Pink


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: BmiViewModel){

    val isResultDialog = remember { mutableStateOf(false) }
    var isEnable by remember { mutableStateOf(false) }

    ResultDialog(
        isOpen = isResultDialog,
        result = ResultModel(
            gender = viewModel.isGender,
            type = viewModel.calculateType(),
            weight = viewModel.sliderPosition.toInt(),
            height = viewModel.feetValue,
            inch = viewModel.inchesValue,
            result = viewModel.bmiResult
    ))

    fun getColor(gender:String):Color{
        return if (gender==viewModel.isGender) {
            isEnable=true
            Pink
        } else BlueLight
    }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BlueDark,
                titleContentColor = GrayLight
            ),
            title = { Text(text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.bodyLarge)})
        }
    ) {padding->
        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxHeight()
                .background(BlueDark)
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Top Card UI
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
               CustomCard(
                   modifier = Modifier
                       .weight(0.5f)
                       .fillMaxHeight(0.3f)
                       .background(
                           color = getColor("male"),
                           shape = RoundedCornerShape(8.dp)
                       ),
                   label = "Male",
                   icon = painterResource(id = R.drawable.male),
                   onClick = { viewModel.isGender="male"}
               )
                Spacer(modifier = Modifier.width(20.dp))
                CustomCard(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(0.3f)
                        .background(
                            color = getColor("female"),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    label = "Female",
                    icon = painterResource(id = R.drawable.female),
                    onClick = { viewModel.isGender="female" }
                )
            }

            //Slider Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(
                        color = BlueLight,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Your Weight",
                        style = MaterialTheme.typography.bodyLarge,
                        color = GrayLight)

                    Text(
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                        text = "${viewModel.sliderPosition.toInt()} KG",
                        style = MaterialTheme.typography.titleLarge,
                        color = GrayLight)
                    Slider(
                        value = viewModel.sliderPosition,
                        onValueChange ={viewModel.sliderPosition=it},
                        valueRange = 0f..120f,
                        colors = SliderDefaults.colors(
                            thumbColor = Pink,
                            activeTrackColor = Pink,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                    )
                }
            }

            //Bottom Bar Box
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){

              BottomCard(
                  modifier = Modifier
                      .weight(0.5f)
                      .fillMaxHeight(0.7f)
                      .padding(top = 10.dp)
                      .background(
                          color = BlueLight,
                          shape = RoundedCornerShape(8.dp)
                      ),
                  label ="Feet",
                  value = viewModel.feetValue.toString(),
                  increment = {
                      if (viewModel.feetValue<=10){
                          viewModel.feetValue++
                  } },
                  decrement = {
                      if (viewModel.feetValue>=1){
                          viewModel.feetValue--
                      }
                  }
              )

                Spacer(modifier = Modifier.width(20.dp))

                BottomCard(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(0.7f)
                        .padding(top = 10.dp)
                        .background(
                            color = BlueLight,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    label ="Inches",
                    value = viewModel.inchesValue.toString(),
                    increment = {
                        if (viewModel.inchesValue<=10){
                            viewModel.inchesValue++
                        } },
                    decrement = {
                        if (viewModel.inchesValue>=1){
                            viewModel.inchesValue--
                        }
                    }
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

           Button(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(50.dp)
                   .clip(shape = RoundedCornerShape(5.dp),)
                   .background(BlueLight),
               colors = ButtonDefaults.buttonColors(containerColor = Pink),
               shape = RoundedCornerShape(5.dp),
               enabled = isEnable,
               onClick = {
                   if (viewModel.isGender!=""){
                       isResultDialog.value=true
                       viewModel.calculateBMI()
                   }

               }) {
               Text(
                   text = stringResource(id = R.string.calculate).uppercase(),
                   style = MaterialTheme.typography.bodyLarge.copy(
                       if (isEnable) GrayLight else  Color.Gray
                   ))
           }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

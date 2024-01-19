package com.example.bmi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel:ViewModel() {

    var isGender by mutableStateOf("")
    var sliderPosition by mutableFloatStateOf(60f)
    var feetValue by mutableIntStateOf(5)
    var inchesValue by mutableIntStateOf(6)
     var bmiResult by mutableDoubleStateOf(0.0)

    fun calculateBMI(){
        val height= (feetValue*12)+inchesValue
        val _height = (height*0.0254)
        bmiResult = sliderPosition/(_height*_height)
    }

    fun calculateType(): String {
        return if (bmiResult>=25){
            "Overweight"
        } else if(bmiResult>=18.5){
            "Normal"
        }else{
            "Underweight"
        }
    }
}
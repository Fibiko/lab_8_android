package com.example.lab_8

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

object singlton {
    val value1LiveData = MutableLiveData<Float>()
    public val doshik = 66
    public val catfood = 26
    public val sweets = 390

    fun updateValue(newValue: Float, type: Int){
        when (type){
            1 ->
                value1LiveData.value = newValue
            2 ->
                value1LiveData.value = newValue * doshik
            3 ->
                value1LiveData.value = newValue * catfood
            4 ->
                value1LiveData.value = newValue * sweets
        }
        Log.i("User debug","Singltone value changed. New value = ${value1LiveData.value}")
    }
}
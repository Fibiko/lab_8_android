package com.example.lab_8

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    // Currency values
    var isInteracting = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Edit texts by ID
        val etValue1 = findViewById<EditText>(R.id.value1)
        val etValue2 = findViewById<EditText>(R.id.value2)
        val etValue3 = findViewById<EditText>(R.id.value3)
        val etValue4 = findViewById<EditText>(R.id.value4)

        etValue1.doAfterTextChanged {
            if (isInteracting){
                singlton.updateValue(etValue1.text.toString().toFloat(), 1)
            }
        }
        etValue2.doAfterTextChanged {
            if (isInteracting){
                singlton.updateValue(etValue1.text.toString().toFloat(), 2)
            }
        }
        etValue3.doAfterTextChanged {
            if (isInteracting){
                singlton.updateValue(etValue1.text.toString().toFloat(), 3)
            }
        }
        etValue4.doAfterTextChanged {
            if (isInteracting) {
                singlton.updateValue(etValue1.text.toString().toFloat(),4)
            }
        }
        singlton.value1LiveData.observe(this, Observer{
            isInteracting = false
            val uniValue = singlton.value1LiveData.value ?: 0f
            etValue1.setText(uniValue.toString())
            etValue2.setText((uniValue / singlton.doshik).toString())
            etValue3.setText((uniValue / singlton.catfood).toString())
            etValue4.setText((uniValue / singlton.sweets).toString())
            isInteracting = true
        })
    }
}
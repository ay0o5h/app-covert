package com.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textNumber:TextView
    lateinit var resultBtn:Button
    lateinit var clearBtn:Button
    lateinit var fromType:Spinner
    lateinit var toType:Spinner
    lateinit var selectedFrom:String
    lateinit var selectedToType:String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addCallbacks()

        fromType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position)
                selectedFrom=selectedItem.toString();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
        toType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position)
                selectedToType=selectedItem.toString();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }
    private  fun initView(){
        resultBtn=findViewById(R.id.result);
        clearBtn=findViewById(R.id.clear);
        textNumber=findViewById(R.id.number);
        fromType=findViewById(R.id.from_spinner);
        toType=findViewById(R.id.to_spinner);

        selectedToType=""
        selectedFrom=""
    }
    private fun addCallbacks(){
        clearBtn.setOnClickListener{
            print("clear")
            clearInput()
        }
        resultBtn.setOnClickListener {
            val input = textNumber.text.toString()
            var result =""
            var type="$selectedFrom to $selectedToType"

            when (type) {
                "Decimal to Binary" -> {
                    val decimal = input.toInt()
                    result = ConvertNumber.decimalToBinary(decimal)
                }
                "Decimal to Octal" -> {
                    val decimal = input.toInt()
                    result = ConvertNumber.decimalToOctal(decimal)
                }
                "Decimal to Hexadecimal" -> {
                    val decimal = input.toInt()
                    result = ConvertNumber.decimalToHexadecimal(decimal)
                }
                "Binary to Decimal" -> {
                    val decimal = ConvertNumber.binaryToDecimal(input)
                    result = decimal.toString()
                }
                "Binary to Octal" -> {
                    result = ConvertNumber.binaryToOctal(input)
                }
                "Binary to Hexadecimal" -> {
                    result = ConvertNumber.binaryToHexadecimal(input)
                }
                "Octal to Binary" -> {
                    result = ConvertNumber.octalToBinary(input)
                }
                "Octal to Decimal" -> {
                    val decimal = ConvertNumber.octalToDecimal(input)
                    result = decimal.toString()
                }
                "Octal to Hexadecimal" -> {
                    result = ConvertNumber.octalToHexadecimal(input)
                }
                "Hexadecimal to Binary" -> {
                    result = ConvertNumber.hexadecimalToBinary(input)
                }
                "Hexadecimal to Octal" -> {
                    result = ConvertNumber.hexadecimalToOctal(input)
                }
                "Hexadecimal to Decimal" -> {
                    val decimal = ConvertNumber.hexadecimalToDecimal(input)
                    result = decimal.toString()
                }
            }
        textNumber.text= result
        }
    }
    fun clearInput(){
        textNumber.text=   textNumber.text.toString().dropLast(1)
    }
    fun onClickNumber(v:View){
        val newDigit=(v as Button).text.toString()
        val oldDigit=textNumber.text.toString()
        val newTextNumber=oldDigit+newDigit
        textNumber.text=newTextNumber
    }
}



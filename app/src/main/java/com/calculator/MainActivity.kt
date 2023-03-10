package com.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

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
            val result=convertNumber(textNumber.text.toString())
            print(result)
            val type = when (selectedToType) {
                "Binary" -> Integer.toBinaryString(input.toInt())
               "Octal" -> Integer.toOctalString(input.toInt())
                "Decimal" -> Integer.toHexString(input.toInt())
                "Hexadecimal" -> Integer.toHexString(input.toInt())
                else -> 10
            }


            val output = try {
                Integer.parseInt("7", 2)
            } catch (e: NumberFormatException) {
                textNumber.text=e.toString()
                print(e)
                null
            }
        textNumber.text= type.toString()
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



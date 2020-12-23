package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNo = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View){

        if(isNewOp)
            editText.setText("")

        isNewOp = false

        var no : String = editText.text.toString()
        var select : Button = view as Button

        when(select.id){

            btn1.id -> {no += "1"}
            btn2.id -> {no += "2"}
            btn3.id -> {no += "3"}
            btn4.id -> {no += "4"}
            btn5.id -> {no += "5"}
            btn6.id -> {no += "6"}
            btn7.id -> {no += "7"}
            btn8.id -> {no += "8"}
            btn9.id -> {no += "9"}
            btn0.id -> {no += "0"}
            btnDot.id -> {no += "."}

        }
        editText.setText(no)
    }

    fun operatorEvent(view: View){

        isNewOp = true
        oldNo = editText.text.toString()
        var selectop = view as Button

        when(selectop.id){

            btnMinus.id -> {op = "-"}
            btnMultiply.id -> {op = "*"}
            btnPlus.id -> {op = "+"}
            btnDivision.id -> {op = "/"}
        }
    }

    fun equalEvent(view: View){

        var newNo: String = editText.text.toString()
        var results = 0.0

        when(op){

            "+" -> {results = oldNo.toDouble() + newNo.toDouble()}
            "-" -> {results = oldNo.toDouble() - newNo.toDouble()}
            "*" -> {results = oldNo.toDouble() * newNo.toDouble()}
            "/" -> {results = oldNo.toDouble() / newNo.toDouble()}

        }
        editText.setText(results.toString())
    }

    fun acEvent(view: View){

        editText.setText("0")
        isNewOp = true

    }

    fun percentageEvent(view: View){

        var n = editText.text.toString().toDouble()/100
        editText.setText(n.toString())
        isNewOp = true
    }
}



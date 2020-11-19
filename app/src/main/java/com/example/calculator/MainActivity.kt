package com.example.calculator

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    var input : TextView? = null
    var input_text = ""
    var zero : ImageButton? = null
    var one : ImageButton? = null
    var two : ImageButton? = null
    var three : ImageButton? = null
    var four : ImageButton? = null
    var five : ImageButton? = null
    var six : ImageButton? = null
    var seven : ImageButton? = null
    var eight : ImageButton? = null
    var nine : ImageButton? = null
    var plus : ImageButton? = null
    var minus : ImageButton? = null
    var multiply : ImageButton? = null
    var divide : ImageButton? = null
    var percent : ImageButton? = null
    var AC : ImageButton? = null
    var plus_minus : ImageButton? = null
    var equal : ImageButton? = null
    var comma : ImageButton? = null

    var firstNumber: Double = 0.0
    var secondNumber: Double = 0.0
    var result = ""
    var currentOperation = ""
    var LENGTH = 0
    var currentOperationIsPercentage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        fun getFloatNum(str: String): Double {
            var indexOfComma = str.indexOf('.')
            var mainPart = 0
            var dec = 1
            var num: Int
            for (i in indexOfComma-1 downTo 0) {
                num = str[i].toInt()
                num -= 48
                mainPart += num * dec
                dec *= 10
            }
            var fracPart = 0.0
            var quan = 0
            dec = 1
            for (i in str.length - 1 downTo indexOfComma + 1) {
                fracPart += (str[i].toInt() - 48) * dec
                dec *= 10
                quan++
            }
            fracPart = fracPart / dec
            return mainPart + fracPart
        }

        fun toastError () {
            val myToast = Toast.makeText(applicationContext, "Invalid Expression", Toast.LENGTH_SHORT)
            myToast.show()
        }

        input = findViewById(R.id.input)
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        plus_minus = findViewById(R.id.plus_minus)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        percent = findViewById(R.id.percent)
        AC = findViewById(R.id.AC)
        comma = findViewById(R.id.comma)
        equal = findViewById(R.id.equal)

        //setting up listeners on number buttons
            zero?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "0"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            one?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "1"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            two?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "2"
                    input?.text = input_text
                    LENGTH++
                }
            }
            three?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "3"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            four?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "4"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            five?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "5"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            six?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "6"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            seven?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "7"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            eight?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "8"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            nine?.setOnClickListener {
                if (LENGTH <= 9) {
                    input_text += "9"
                    input?.text = input_text
                    LENGTH++
                } else {
                    toastError()
                }
            }
            comma?.setOnClickListener {
                if (LENGTH <= 10 && input_text != "") {
                    input_text += "."
                    input?.text = input_text
                } else {
                    toastError()
                }
            }
        //the end of number buttons listeners

        //setting up listeners on operation buttons
            AC?.setOnClickListener {
                input_text = ""
                input?.setText(input_text)
                currentOperation = ""
                firstNumber = 0.0
                secondNumber = 0.0
                result = ""
                LENGTH = 0
                currentOperationIsPercentage = false
            }
            plus?.setOnClickListener {
                if (LENGTH <= 9 && input_text != "" && !input_text.contains("+")
                        && !input_text.substring(1..input_text.length - 1).contains("-") && !input_text.contains("*")
                        && !input_text.contains("÷")) {
                    if (!input_text.contains(".")) {
                        firstNumber = input_text.toDouble()
                    } else {
                        firstNumber = getFloatNum(input_text)
                    }
                    input_text += "+"
                    input?.setText(input_text)
                    currentOperation = "plus"
                    LENGTH++
                } else {
                    toastError()
                }
            }
            minus?.setOnClickListener {
                if (LENGTH <= 9 && input_text != "" && !input_text.contains("+")
                        && !input_text.substring(1..input_text.length - 1).contains("-") && !input_text.contains("*")
                        && !input_text.contains("÷")) {
                    if (!input_text.contains(".")) {
                        firstNumber = input_text.toDouble()
                    } else {
                        firstNumber = getFloatNum(input_text)
                    }
                    input_text += "-"
                    input?.setText(input_text)
                    currentOperation = "minus"
                    LENGTH++
                } else {
                    toastError()
                }
            }
            multiply?.setOnClickListener {
                if (LENGTH <= 9 && input_text != "" && !input_text.contains("+")
                        && !input_text.substring(1..input_text.length - 1).contains("-") && !input_text.contains("*")
                        && !input_text.contains("÷")) {
                    if (!input_text.contains(".")) {
                        firstNumber = input_text.toDouble()
                    } else {
                        firstNumber = getFloatNum(input_text)
                    }
                    input_text += "*"
                    input?.setText(input_text)
                    currentOperation = "multiply"
                    LENGTH++
                } else {
                    toastError()
                }
            }
            divide?.setOnClickListener {
                if (LENGTH <= 9 && input_text != "" && !input_text.contains("+")
                        && !input_text.substring(1..input_text.length - 1).contains("-") && !input_text.contains("*")
                        && !input_text.contains("÷")) {
                    if (!input_text.contains(".")) {
                        firstNumber = input_text.toDouble()
                    } else {
                        firstNumber = getFloatNum(input_text)
                    }
                    input_text += "÷"
                    input?.setText(input_text)
                    currentOperation = "divide"
                    LENGTH++
                } else {
                    toastError()
                }
            }
            plus_minus?.setOnClickListener {
                if (input_text == "") {
                    toastError()
                } else if (LENGTH <= 8 && input_text != "" && input_text != "" && !input_text.contains("+")
                        && !input_text.contains("-") && !input_text.contains("*")
                        && !input_text.contains("÷")) {
                    input_text = input_text.padStart(input_text.length + 1, '-')
                    input?.text = input_text
                } else if (input_text[0] == '-') {
                    input_text = input_text.removeRange(0..0)
                    input?.text = input_text
                } else {
                    toastError()
                }

            }

            percent?.setOnClickListener {
                if ("+" in input_text || "-" in input_text || "*" in input_text || "÷" in input_text) {
                    if (input_text.last() != '+' && input_text.last() != '-' && input_text.last() != '*' && input_text.last() != '÷') {
                        input_text += "%"
                        input?.text = input_text
                        currentOperationIsPercentage = true
                    } else toastError()
                } else toastError()
            }

            equal?.setOnClickListener {
                if ("+" in input_text || "-" in input_text || "*" in input_text || "÷" in input_text) {
                    if (input_text.last() != '+' && input_text.last() != '-' && input_text.last() != '*' && input_text.last() != '÷') {
                        var indexOfSecondNumberBegin = 0
                        for (i in 1..input_text.length - 1) {
                            if (input_text[i] == '+' || input_text[i] == '-' || input_text[i] == '*' || input_text[i] == '÷') {
                                indexOfSecondNumberBegin = i + 1
                                break
                            }
                        }
                        if (!input_text.substring(indexOfSecondNumberBegin).contains('.')) {
                            if (!currentOperationIsPercentage) {
                                secondNumber = input_text.substring(indexOfSecondNumberBegin).toDouble()
                            } else {
                                secondNumber = input_text.substring(indexOfSecondNumberBegin, input_text.length - 1).toDouble()
                            }
                        } else {
                            if (!currentOperationIsPercentage) {
                                secondNumber = getFloatNum(input_text.substring(indexOfSecondNumberBegin))
                            } else {
                                secondNumber = getFloatNum(input_text.substring(indexOfSecondNumberBegin, input_text.length - 1))
                            }
                        }

                        if (currentOperation == "plus") {
                            if (!currentOperationIsPercentage) {
                                if (firstNumber + secondNumber == (firstNumber + secondNumber).toInt().toDouble()) {
                                    result = (firstNumber + secondNumber).toInt().toString()
                                } else {
                                    result = (firstNumber + secondNumber).toString()
                                }
                            } else {
                                if (firstNumber + firstNumber*secondNumber/100 == (firstNumber + firstNumber*secondNumber/100).toInt().toDouble()) {
                                    result = (firstNumber + firstNumber*secondNumber/100).toInt().toString()
                                } else {
                                    result = (firstNumber + firstNumber*secondNumber/100).toString()
                                }
                            }
                        } else if (currentOperation == "minus") {
                            if (!currentOperationIsPercentage) {
                                if (firstNumber - secondNumber == (firstNumber - secondNumber).toInt().toDouble()) {
                                    result = (firstNumber - secondNumber).toInt().toString()
                                } else {
                                    result = (firstNumber - secondNumber).toString()
                                }
                            } else {
                                if (firstNumber - firstNumber*secondNumber/100 == (firstNumber - firstNumber*secondNumber/100).toInt().toDouble()) {
                                    result = (firstNumber - firstNumber*secondNumber/100).toInt().toString()
                                } else {
                                    result = (firstNumber - firstNumber*secondNumber/100).toString()
                                }
                            }
                        } else if (currentOperation == "multiply") {
                            if (!currentOperationIsPercentage) {
                                if (firstNumber * secondNumber == (firstNumber * secondNumber).toInt().toDouble()) {
                                    result = (firstNumber * secondNumber).toInt().toString()
                                } else {
                                    result = (firstNumber * secondNumber).toString()
                                }
                            } else {
                                if (firstNumber * firstNumber*secondNumber/100 == (firstNumber * firstNumber*secondNumber/100).toInt().toDouble()) {
                                    result = (firstNumber * firstNumber*secondNumber/100).toInt().toString()
                                } else {
                                    result = (firstNumber * firstNumber*secondNumber/100).toString()
                                }
                            }
                        } else if (currentOperation == "divide") {
                            if (!currentOperationIsPercentage) {
                                if (firstNumber / secondNumber == (firstNumber / secondNumber).toInt().toDouble()) {
                                    result = (firstNumber / secondNumber).toInt().toString()
                                } else {
                                    result = (firstNumber / secondNumber).toString()
                                }
                            } else {
                                if (firstNumber / firstNumber*secondNumber/100 == (firstNumber / firstNumber*secondNumber/100).toInt().toDouble()) {
                                    result = (firstNumber / firstNumber*secondNumber/100).toInt().toString()
                                } else {
                                    result = (firstNumber / firstNumber*secondNumber/100).toString()
                                }
                            }
                        }
                        if (result.length >= 10) {
                            input_text = result.substring(0, 11)
                        } else {
                            input_text = result;
                        }
                        input?.text = input_text
                        if (input_text.contains('.')) {
                            LENGTH = input_text.length - 1
                        } else {
                            LENGTH = input_text.length
                        }
                    } else {
                        toastError()
                    }
                } else {
                    toastError()
                }
            }
        //the end of operation buttons listeners
    }


}
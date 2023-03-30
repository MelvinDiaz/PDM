package com.example.scorewithviewmodel.model

class NumberProvider {

    companion object {


        fun addNumberA(number: Int): NumberModelA {
            return NumberModelA(number + 1)
        }
        fun addNumberB(number: Int): NumberModelB {
            return NumberModelB(number + 1)
        }

    }
}
package com.example.scorewithviewmodel.model

class NumberProvider {

    companion object {
        val _numberA = 0
        val _numberB = 0

        fun addNumberA(): NumberModelA {
            return NumberModelA(_numberA + 1)
        }
        fun addNumberB(): NumberModelB {
            return NumberModelB(_numberB + 1)
        }

    }
}
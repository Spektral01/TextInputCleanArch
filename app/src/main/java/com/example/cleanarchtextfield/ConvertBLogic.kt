package com.example.cleanarchtextfield

class ConvertBLogic {
    fun isCorrect(input: String): Boolean{
        if (input.length != 10 || !input.all { it.isDigit() }) {
            return false
        }
        return true
    }

    fun ConvertNums(input: String): String {
        return "+7 (${input.substring(0, 3)}) " +
                "${input.substring(3, 6)} " +
                "${input.substring(6, 8)}" +
                " ${input.substring(8)}"
    }
}
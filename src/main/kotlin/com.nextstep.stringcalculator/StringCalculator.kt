package com.nextstep.stringcalculator

import java.lang.IllegalArgumentException
import java.lang.RuntimeException

object StringCalculator {
    fun calculateDelimiters(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val tokens = input.split(",", ":")
        val regex = Regex("//(.)\n(.*)").find(input)
        val result = regex?.let { it ->
            val customDelimiter = it.groupValues[1]
            val customDelimiterTokens = it.groupValues[2].split(customDelimiter)
            sum(customDelimiterTokens)
        } ?: sum(tokens)

        return result
    }

    private fun sum(tokens: List<String>) = tokens.sumOf { toInt(it) }

    private fun toInt(input: String): Int = try {
        val inputNumber = input.toInt()
        if (inputNumber < 0) {
            throw RuntimeException()
        }
        inputNumber
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("invalid input - $input")
    }
}

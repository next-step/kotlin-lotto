package com.nextstep.stringcalculator

import java.lang.RuntimeException

object StringCalculator {
    private const val CUSTOM_DELIMITER_POSITION = 1
    private const val CUSTOM_INPUT_POSITION = 2

    private val CUSTOM_MATCHING_PATTERN = Regex("//(.)\n(.*)")

    fun calculateDelimiters(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val tokens = input.split(",", ":")
        val regex = CUSTOM_MATCHING_PATTERN.find(input)
        val result = regex?.let {
            val customDelimiter = it.groupValues[CUSTOM_DELIMITER_POSITION]
            val customDelimiterTokens = it.groupValues[CUSTOM_INPUT_POSITION].split(customDelimiter)
            sum(customDelimiterTokens)
        } ?: sum(tokens)

        return result
    }

    private fun sum(tokens: List<String>) = tokens.sumOf { toInt(it) }

    private fun toInt(input: String): Int = input.toInt().takeIf { it >= 0 } ?: throw RuntimeException()
}

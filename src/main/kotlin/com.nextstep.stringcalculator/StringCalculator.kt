package com.nextstep.stringcalculator

import java.lang.RuntimeException

object StringCalculator {
    private const val CUSTOM_DELIMITER_POSITION = 1
    private const val CUSTOM_INPUT_POSITION = 2
    private const val POSSIBLE_CALCULATE_NUMBER_THRESHOLD = 0

    private val CUSTOM_MATCHING_PATTERN = Regex("//(.)\n(.*)")

    fun calculateDelimiters(input: String?): Int {
        require(!input.isNullOrEmpty()) { throw RuntimeException() }
        val tokens = input.split(",", ":")
        val regex = CUSTOM_MATCHING_PATTERN.find(input)
        val result = regex?.let {
            val customDelimiter = it.groupValues[CUSTOM_DELIMITER_POSITION]
            val customDelimiterTokens = it.groupValues[CUSTOM_INPUT_POSITION].split(customDelimiter)
            sum(customDelimiterTokens)
        } ?: sum(tokens)

        return result
    }

    private fun sum(tokens: List<String>) = tokens.sumOf { it.parseInt() }

    private fun greaterOrEqual(it: Int, threshold: Int) = it >= threshold

    private fun String.parseInt(): Int = this.toInt().takeIf {
        greaterOrEqual(
            it,
            POSSIBLE_CALCULATE_NUMBER_THRESHOLD
        )
    } ?: throw RuntimeException()
}

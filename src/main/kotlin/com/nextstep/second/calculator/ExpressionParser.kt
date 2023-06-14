package com.nextstep.second.calculator

object ExpressionParser {
    fun parse(text: String, tokenize: (String) -> List<String>): List<Int> {
        val tokens = if (text.isNotBlank()) tokenize(text) else return emptyList()
        val numberList = changeStringToNumber(tokens)
        return checkForNegative(numberList)
    }

    private fun changeStringToNumber(numStr: List<String>): List<Int> {
        try {
            return numStr.map { it.toInt() }.toList()
        } catch(e : Exception) {
            throw IllegalArgumentException()
        }
    }

    private fun checkForNegative(numbers: List<Int>): List<Int> {
        if (numbers.any { it < 0 }) throw IllegalArgumentException("음수가 포함되어있습니다")
        return numbers
    }
}
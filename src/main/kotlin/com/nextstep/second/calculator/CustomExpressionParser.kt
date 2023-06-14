package com.nextstep.second.calculator

class CustomExpressionParser(text: String?) {
    var numberList: List<Int>
        private set

    init {
        numberList = if (text.isNullOrBlank()) emptyList() else parse(text)
        checkForNegative(numberList)
    }

    private fun parse(text: String): List<Int> {
        try {
            val parsedToken = Regex("//(.)\n(.*)").find(text)
            val numList = mutableListOf<Int>()
            parsedToken?.let {
                val customDelimiter = it.groupValues[1]
                val tokens = it.groupValues[2].split(customDelimiter)
                tokens.map { numList.add(it.toInt()) }
            }
            return numList
        } catch(e: Exception) {
            throw IllegalArgumentException("문자열 형식에 맞지 않습니다")
        }
    }

    private fun checkForNegative(numList: List<Int>) {
        numList.firstOrNull { it < 0 }?.let {
            throw IllegalStateException("음수가 포함되어있습니다: $it")
        }
    }
}
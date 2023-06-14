package com.nextstep.second.calculator

class ExpressionParser(text: String = "") {
    var numberList: List<Int>
        private set

    init {
        numberList = if (text.isBlank()) emptyList() else parse(text)
        checkForNegative(numberList)
    }

    private fun parse(text: String): List<Int> {
        try {
            val tokens = text.split(DELIMITERS.toRegex())
            return tokens.map { it.toInt() }
        } catch(e: Exception) {
            throw IllegalArgumentException("문자열 형식에 맞지 않습니다")
        }
    }

    private fun checkForNegative(numList: List<Int>) {
        numList.firstOrNull { it < 0 }?.let {
            throw IllegalStateException("음수가 포함되어있습니다: $it")
        }
    }

    companion object {
        const val DELIMITERS = "[:,]"
    }
}
package com.nextstep.second.calculator

sealed class ExpressionParser(text: String?) {
    var numberList: List<Int>
        private set

    init {
        numberList = if (text.isNullOrBlank()) emptyList() else parse(text)
        checkForNegative(numberList)
    }

    abstract fun parse(text: String): List<Int>

    private fun checkForNegative(numList: List<Int>) {
        numList.firstOrNull { it < 0 }?.let {
            throw IllegalStateException("음수가 포함되어있습니다: $it")
        }
    }
}
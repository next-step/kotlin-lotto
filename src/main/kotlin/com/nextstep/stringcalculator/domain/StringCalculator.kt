package com.nextstep.stringcalculator.domain

import com.nextstep.stringcalculator.utils.isNegative
import com.nextstep.stringcalculator.utils.split

class StringCalculator(userInput: String) {
    val numbers: List<Int>
    val delimeters: List<String>

    init {
        val splits = splitCustomDelimeterWithNumbers(userInput)
        if (splits != null) {
            this.delimeters = listOf(splits.groupValues[1])
            this.numbers = splitNumbers(splits.groupValues[2])
        } else {
            this.delimeters = DEFAULT_DELIMETERS
            this.numbers = splitNumbers(userInput)
        }

        validationNumbers(this.numbers)
    }

    private fun splitNumbers(numbers: String): List<Int> {
        if (numbers.isNullOrEmpty()) {
            return listOf(0)
        }
        return numbers.split(delimeters).map { it.toInt() }
    }

    private fun splitCustomDelimeterWithNumbers(userInput: String): MatchResult? {
        return Regex(SPLIT_WITH_DELIMETER_REGEX).find(userInput)
    }

    private fun validationNumbers(numbers: List<Int>) {
        require(!numbers.any { it.isNegative() }) { "음수가 존재합니다." }
    }

    fun calculate(): Int {
        return numbers.sum()
    }

    companion object {
        private const val SPLIT_WITH_DELIMETER_REGEX = "//(.)\\\\n(.*)"
        private val DEFAULT_DELIMETERS = listOf(",", ";")
    }
}

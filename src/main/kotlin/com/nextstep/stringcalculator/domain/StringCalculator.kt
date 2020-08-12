package com.nextstep.stringcalculator.domain

import com.nextstep.stringcalculator.utils.isNegative
import com.nextstep.stringcalculator.utils.split

class StringCalculator private constructor(val numbers: List<Int>) {

    init {
        validateNumbers(this.numbers)
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(!numbers.any { it.isNegative() }) { "음수가 존재합니다." }
    }

    fun calculate(): Int {
        return numbers.sum()
    }

    companion object {
        fun createCalculator(userInput: String): StringCalculator {
            val splits = splitCustomDelimeterWithNumbers(userInput)
            if (splits != null) {
                val (delimeter, numbers) = splits.destructured
                val delimeters = listOf(delimeter)
                return StringCalculator(splitNumbers(numbers, delimeters))
            } else {
                return StringCalculator(splitNumbers(userInput, DEFAULT_DELIMETERS))
            }
        }

        private fun splitNumbers(numbers: String, delimeters: List<String>): List<Int> {
            if (numbers.isEmpty()) {
                return listOf(0)
            }
            return numbers.split(delimeters).map { it.toInt() }
        }

        private fun splitCustomDelimeterWithNumbers(userInput: String): MatchResult? {
            return SPLIT_WITH_DELIMETER_REGEX.find(userInput)
        }

        private val SPLIT_WITH_DELIMETER_REGEX = Regex("//(.)\\\\n(.*)")
        private val DEFAULT_DELIMETERS = listOf(",", ";")
    }
}

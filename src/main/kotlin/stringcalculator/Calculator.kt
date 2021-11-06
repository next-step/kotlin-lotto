package stringcalculator

import stringcalculator.utils.getCustomDelimiter
import stringcalculator.utils.getInput
import stringcalculator.utils.toPositiveInt

class Calculator {

    fun calculate(rawInput: String?): Int {
        if (rawInput.isNullOrBlank()) {
            return DEFAULT_RETURN
        }
        return parse(rawInput).sum()
    }

    private fun parse(rawInput: String): List<Int> {
        val result = CUSTOM_DELIMITER_PATTERN.find(rawInput)
        result?.let {
            return splitAndCast(it.getInput, it.getCustomDelimiter)
        }
        return splitAndCast(rawInput)
    }

    private fun splitAndCast(input: String, vararg delimiters: String): List<Int> {
        return input.split(*delimiters, *DEFAULT_DELIMITERS).map { it.toPositiveInt() }
    }

    companion object {
        private const val DEFAULT_RETURN = 0
        private val CUSTOM_DELIMITER_PATTERN = Regex("^//(.*)\n(.*)")
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}

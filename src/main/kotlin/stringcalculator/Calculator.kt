package stringcalculator

import stringcalculator.utils.toPositiveInt

class Calculator {
    fun calculate(rawInput: String?): Int {
        if (rawInput.isNullOrBlank()) {
            return DEFAULT_RETURN
        }
        return rawInput.split(*DEFAULT_DELIMITERS).sumOf { it.toPositiveInt() }
    }

    companion object {
        private const val DEFAULT_RETURN = 0
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}

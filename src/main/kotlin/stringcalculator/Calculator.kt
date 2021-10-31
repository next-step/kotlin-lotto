package stringcalculator

import stringcalculator.utils.toPositiveInt

class Calculator {
    fun calculate(rawInput: String?): Int {
        return rawInput?.split(*DEFAULT_DELIMITERS)!!.sumOf { it.toPositiveInt() }
    }

    companion object {
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}

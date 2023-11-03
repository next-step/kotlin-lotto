package calculator

import calculator.model.Operands

class StringAddCalculator {
    fun add(input: String?): Int {
        return if (input.isNullOrEmpty()) ZERO else Operands.from(makeOperands(input)).calculate()
    }

    private fun makeOperands(input: String): List<String> {
        val result = CUSTOM_DELIMITER.find(input)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return input.split(DEFAULT_DELIMITER)
    }

    companion object {
        private val DEFAULT_DELIMITER = "[,:]".toRegex()
        private val CUSTOM_DELIMITER = "//(.)\n(.*)".toRegex()
        private const val ZERO = 0
    }
}

package calculator

class StringAddCalculator {

    fun calculate(operands: String?): Int {
        if (operands.isNullOrBlank()) {
            return ZERO
        }

        val operandCollection = OperandCollection(split(operands))

        return operandCollection.add()
    }

    private fun split(operands: String): List<String> {
        return splitByCustomDelimiterOrNull(operands) ?: operands.split(DEFAULT_REGEX)
    }

    private fun splitByCustomDelimiterOrNull(operands: String): List<String>? {
        return Regex(CUSTOM_DELIMITER_PATTERN).find(operands)?.let {
            val delimiter = it.groupValues[1]
            it.groupValues[2].split(delimiter)
        }
    }

    companion object {
        private const val DEFAULT_DELIMITERS = "[,:]"
        private val DEFAULT_REGEX = Regex(DEFAULT_DELIMITERS)
        private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
        private const val ZERO = 0
    }
}

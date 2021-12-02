package stringaddcalculator.domain

class Calculation(val expression: String, val customDelimiter: String = EMPTY) {
    fun splitExpression(): List<String> {
        return if (customDelimiter.isBlank()) {
            expression.split(ADD_DELIMITER.toRegex())
        } else {
            expression.split(customDelimiter)
        }
    }

    companion object {
        private const val EMPTY = ""
        private const val EXPRESSION = 2
        private const val CUSTOM_DELIMITER = 1
        private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
        const val ADD_DELIMITER = "[,:]"

        fun getCalculation(input: String): Calculation {
            return if (hasCustomDelimiter(input)) {
                val find = Regex(CUSTOM_DELIMITER_REGEX).find(input)!!
                Calculation(expression = find.groupValues[EXPRESSION], customDelimiter = find.groupValues[CUSTOM_DELIMITER])
            } else {
                Calculation(expression = input)
            }
        }

        fun hasCustomDelimiter(input: String) = Regex(CUSTOM_DELIMITER_REGEX).containsMatchIn(input)
    }
}

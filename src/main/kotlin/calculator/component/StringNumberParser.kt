package calculator.component

class StringNumberParser {
    fun getNumbers(expression: String?): List<Int> {
        if (expression.isNullOrBlank()) {
            return listOf(0)
        }

        val customSeparator = getCustomSeparator(expression)
        val separatorRegex = getSeparatorRegex(customSeparator)
        val stringNumbersExpression = getStringNumbersExpression(expression, customSeparator)

        return getNumbers(stringNumbersExpression, separatorRegex)
    }

    private fun getCustomSeparator(input: String): String? {
        return Regex(CUSTOM_SEPARATOR_PATTERN).find(input)
            ?.groupValues
            ?.get(1)
    }

    private fun getSeparatorRegex(customSeparator: String?): Regex {
        val customSeparatorPattern = if (customSeparator != null) {
            """|$customSeparator"""
        } else {
            ""
        }

        return (DEFAULT_SEPARATOR_PATTERN + customSeparatorPattern).toRegex()
    }

    private fun getStringNumbersExpression(input: String, customSeparator: String?): String {
        return if (customSeparator != null) {
            input.split(CUSTOM_SEPARATOR_STRING_NUMBERS_SEPARATOR)[1]
        } else {
            input
        }
    }

    private fun getNumbers(stringNumbersExpression: String, separatorRegex: Regex): List<Int> {
        if (stringNumbersExpression.isBlank()) {
            return listOf(0)
        }

        return stringNumbersExpression
            .split(separatorRegex)
            .map { convertStringNumberToInt(it) }
    }

    private fun convertStringNumberToInt(stringNumber: String): Int {
        return try {
            stringNumber
                .toULong()
                .toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자는 0 또는 자연수만 가능합니다. $stringNumber")
        }
    }

    companion object {
        private const val DEFAULT_SEPARATOR_PATTERN = """,|:"""
        private const val CUSTOM_SEPARATOR_STRING_NUMBERS_SEPARATOR = "\\n"
        private const val CUSTOM_SEPARATOR_PATTERN = """^//(.)\\n(.*)$"""
    }
}

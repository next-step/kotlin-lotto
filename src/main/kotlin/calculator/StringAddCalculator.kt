package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        val value = validateWithConvertZero(text)
        val values = getValues(value)
        validate(values)
        return values
            .sumOf { it.toInt() }
    }

    private fun validate(values: List<String>) {
        values.forEach {
            if (it.toInt() < 0) {
                throw RuntimeException()
            }
        }
    }

    private fun getValues(value: String): List<String> {
        val result = Regex(CUSTOM_DELIMITER).find(value)
        result?.let {
            val customDelimiter = it.groupValues[CUSTOM_DELIMITER_INDEX]
            return it.groupValues[CUSTOM_DELIMITER_EXPRESSION_INDEX].split(customDelimiter)
        }

        return value.split(DEFAULT_DELIMITER.toRegex())
    }

    private fun validateWithConvertZero(text: String?): String = when {
        text.isNullOrEmpty() -> ZERO
        text.isBlank() -> ZERO
        else -> text
    }

    companion object {
        private const val ZERO = "0"
        private const val DEFAULT_DELIMITER = "[,:]"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
        private const val CUSTOM_DELIMITER_INDEX = 1
        private const val CUSTOM_DELIMITER_EXPRESSION_INDEX = 2
    }
}

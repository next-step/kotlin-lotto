package stringcalculator.dto

class InputDto(expression: String) {
    var customSeparatorString: String? = null
        private set
    val numbersString: String

    init {
        if (!hasCustomSeparator(expression)) {
            numbersString = expression
        } else {
            val customSeparatorEndIndex = expression.indexOf(CUSTOM_SEPARATOR_END)
            customSeparatorString = expression.slice(0..customSeparatorEndIndex)
            numbersString = expression.substring(customSeparatorEndIndex + CUSTOM_SEPARATOR_END.length)
        }
        validate()
    }

    private fun validate() {
        validateForNumbersString(numbersString, customSeparatorString?.let { getCustomSeparator(it) })
    }

    companion object {
        private const val CUSTOM_SEPARATOR_START = "//"
        private const val CUSTOM_SEPARATOR_END = "\n"

        private val COMMON_SEPARATOR: List<String> = listOf(":", ",")
        private const val ERROR_MESSAGE_OTHER_STRING_CONTAIN = "연삭식에 숫자, 구분자를 제외한 문자가 들어가 있습니다."

        private fun getNumberStringRegex(customSeparatorString: String?): Regex {
            return Regex("((\\d)([${COMMON_SEPARATOR.joinToString(separator = "")}${customSeparatorString?.let { customSeparatorString }}])?)+")
        }

        private fun getCustomSeparator(customSeparatorString: String): String {
            return customSeparatorString.substring(
                customSeparatorString.indexOf(CUSTOM_SEPARATOR_START) + CUSTOM_SEPARATOR_START.length,
                customSeparatorString.indexOf(CUSTOM_SEPARATOR_END)
            )
        }

        private fun hasCustomSeparator(expression: String): Boolean {
            return expression.substring(0, CUSTOM_SEPARATOR_START.length) == CUSTOM_SEPARATOR_START &&
                expression.contains(CUSTOM_SEPARATOR_END)
        }

        private fun validateForNumbersString(expression: String, customSeparatorString: String? = null) {
            require(getNumberStringRegex(customSeparatorString).matches(expression)) { ERROR_MESSAGE_OTHER_STRING_CONTAIN }
        }
    }
}

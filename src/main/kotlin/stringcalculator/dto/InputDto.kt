package stringcalculator.dto

import stringcalculator.domain.Separator

class InputDto(expression: String) {
    var customSeparatorString: String? = null
        private set
    val numbersString: String

    init {
        if (!Separator.hasCustomSeparator(expression)) {
            numbersString = expression
        } else {
            customSeparatorString = Separator.getCustomString(expression)
            numbersString = expression.substring(Separator.getCustomSeparatorEndIndexWithSepartorSize(expression))
        }
        validate()
    }

    private fun validate() {
        validateForNumbersString(numbersString, customSeparatorString?.let { Separator.getCustomSeparator(it) })
    }

    companion object {
        private val COMMON_SEPARATOR: List<String> = listOf(":", ",")
        private const val ERROR_MESSAGE_OTHER_STRING_CONTAIN = "연삭식에 숫자, 구분자를 제외한 문자가 들어가 있습니다."

        private fun getNumberStringRegex(customSeparatorString: String?): Regex {
            return Regex("((\\d)([${COMMON_SEPARATOR.joinToString(separator = "")}${customSeparatorString?.let { customSeparatorString }}])?)+")
        }

        private fun validateForNumbersString(expression: String, customSeparatorString: String? = null) {
            require(getNumberStringRegex(customSeparatorString).matches(expression)) { ERROR_MESSAGE_OTHER_STRING_CONTAIN }
        }
    }
}

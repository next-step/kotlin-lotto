package stringcalculator.dto

import stringcalculator.domain.Separator

class InputDto(val expression: String) {

    init {
        validate()
    }

    private fun validate() {
        val expression = expression.substring(0, Separator.getCustomSeparatorEndIndexWithSepartorSize(expression))
        validateForNumbersString(expression)
    }

    companion object {
        private val COMMON_SEPARATOR: List<String> = listOf(":", ",")
        private const val ERROR_MESSAGE_OTHER_STRING_CONTAIN = "연삭식에 숫자, 구분자를 제외한 문자가 들어가 있습니다."

        private fun getNumberStringRegex(separators: List<String>): Regex {
            return Regex("((\\d)([${separators.joinToString(separator = "")}])?)+")
        }

        private fun validateForNumbersString(expression: String, separators: List<String>) {
            require(getNumberStringRegex(separators).matches(expression)) { ERROR_MESSAGE_OTHER_STRING_CONTAIN }
        }
    }
}

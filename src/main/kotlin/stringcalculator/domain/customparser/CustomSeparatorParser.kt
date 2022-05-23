package stringcalculator.domain.customparser

class CustomSeparatorParser(stringCustomSeparator: String) {
    val parserSeparator: ParserSeparator

    init {
        validateStringCustomSeparator(stringCustomSeparator)
        val separatorString = subStringByString(stringCustomSeparator, START_STRING, END_STRING)
        parserSeparator = ParserSeparator(separatorString)
        validateSeparatorForMinus(parserSeparator)
    }

    private fun subStringByString(
        stringCustomSeparator: String,
        startString: String,
        endString: String
    ): String {
        val startIndex = stringCustomSeparator.indexOf(startString) + startString.length
        val endIndex = stringCustomSeparator.indexOf(endString, startIndex)
        return stringCustomSeparator.substring(startIndex, endIndex)
    }

    companion object {
        private const val START_STRING = "//"
        private const val END_STRING = "\n"
        private const val MINUS = "-"
        private const val ERROR_MESSAGE_START_STRING_NOT_CONTAIN = "시작을 구분하는 문자열($START_STRING)이 포함되어 있지 않습니다"
        private const val ERROR_MESSAGE_END_STRING_NOT_CONTAIN = "끝을 구분하는 문자열($END_STRING)이 포함되어 있지 않습니다"
        private const val ERROR_MESSAGE_CUSTOM_SEPARATOR_NOT_MINUS = "커스텀 구분자는 - 가 될수 없습니다"
        val REGEX_CUSTOM_SEPARATOR_EXPRESSION = Regex("^$START_STRING.+$END_STRING")

        private fun validateStringCustomSeparator(stringCustomSeparator: String) {
            validateNotContainStartString(stringCustomSeparator, START_STRING)
            validateNotContainEndString(stringCustomSeparator, START_STRING, END_STRING)
        }

        private fun validateNotContainStartString(stringCustomSeparator: String, startString: String) {
            require(stringCustomSeparator.indexOf(startString) >= 0) { ERROR_MESSAGE_START_STRING_NOT_CONTAIN }
        }

        private fun validateNotContainEndString(stringCustomSeparator: String, startString: String, endString: String) {
            val startIndex = stringCustomSeparator.indexOf(startString)
            require(stringCustomSeparator.indexOf(endString, startIndex) >= 0) { ERROR_MESSAGE_END_STRING_NOT_CONTAIN }
        }

        private fun validateSeparatorForMinus(parserSeparator: ParserSeparator) {
            require(parserSeparator.string != MINUS) { ERROR_MESSAGE_CUSTOM_SEPARATOR_NOT_MINUS }
        }
    }
}

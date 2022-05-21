package stringcalculator.domain

class StringCustomSeparatorParser(stringCustomSeparator: String) {
    val parserSeparator: ParserSeparator

    init {
        validateStringCustomSeparator(stringCustomSeparator)
        val separatorString = subStringByString(stringCustomSeparator, START_STRING, END_STRING)
        parserSeparator = ParserSeparator(separatorString)
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
        private const val ERROR_MESSAGE_START_STRING_NOT_CONTAIN = "시작을 구분하는 문자열($START_STRING)이 포함되어 있지 않습니다"
        private const val ERROR_MESSAGE_END_STRING_NOT_CONTAIN = "끝을 구분하는 문자열($END_STRING)이 포함되어 있지 않습니다"

        fun findEndIndexForSubstring(expression: String): Int {
            val findIndex = expression.indexOf(END_STRING)
            if (findIndex < 0) {
                return findIndex
            }
            return findIndex + END_STRING.length
        }

        private fun validateStringCustomSeparator(stringCustomSeparator: String) {
            validateStartContain(stringCustomSeparator, START_STRING)
            validateEndStringContains(stringCustomSeparator, START_STRING, END_STRING)
        }

        private fun validateStartContain(stringCustomSeparator: String, startString: String) {
            require(stringCustomSeparator.indexOf(startString) >= 0) { ERROR_MESSAGE_START_STRING_NOT_CONTAIN }
        }

        private fun validateEndStringContains(stringCustomSeparator: String, startString: String, endString: String) {
            val startIndex = stringCustomSeparator.indexOf(startString)
            require(stringCustomSeparator.indexOf(endString, startIndex) >= 0) { ERROR_MESSAGE_END_STRING_NOT_CONTAIN }
        }
    }
}

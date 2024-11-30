package additioncalculator.domain

object DelimiterScanner {
    fun findDelimiters(inputText: String): List<String> {
        checkEmptyInputText(inputText = inputText)

        val resultDelimiters: MutableList<String> = mutableListOf()
        checkDefaultDelimiter(inputText = inputText, mutableDelimiterList = resultDelimiters)

        findCustomDelimiter(inputText = inputText, mutableDelimiterList = resultDelimiters)

        return resultDelimiters
    }

    private fun checkEmptyInputText(inputText: String) {
        require(inputText.isNotBlank()) { DELIMITER_TEXT_NOT_EMPTY_MESSAGE }
    }

    private fun checkDefaultDelimiter(
        inputText: String,
        mutableDelimiterList: MutableList<String>,
    ) {
        if (inputText.contains(DEFAULT_DELIMITER)) {
            mutableDelimiterList.add(DEFAULT_DELIMITER)
        }

        if (inputText.contains(SECOND_DEFAULT_DELIMITER)) {
            mutableDelimiterList.add(SECOND_DEFAULT_DELIMITER)
        }
    }

    private fun findCustomDelimiter(
        inputText: String,
        mutableDelimiterList: MutableList<String>,
    ) {
        val matchResult: MatchResult? = Regex(CUSTOM_DELIMITER_REGEX_PATTERN).find(inputText)

        matchResult?.let {
            mutableDelimiterList.add(it.groupValues[CUSTOM_DELIMITER_REGEX_PATTERN_FIND_INDEX])
        }
    }

    private const val DEFAULT_DELIMITER: String = ","
    private const val SECOND_DEFAULT_DELIMITER: String = ":"
    private const val CUSTOM_DELIMITER_REGEX_PATTERN: String = "//(.)\n(.*)"
    private const val CUSTOM_DELIMITER_REGEX_PATTERN_FIND_INDEX: Int = 1
    const val DELIMITER_TEXT_NOT_EMPTY_MESSAGE: String = "구분자를 찾기 위해 입력된 텍스트가 빈 문자열일 수 없습니다"
}

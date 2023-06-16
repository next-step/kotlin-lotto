package calculator

class ExpressionParser() {

    fun parseInputData(inputString: String): List<String> {
        return isExistCustomDelimiter(inputString)?.let {
            parseCustomDelimiter(it)
        }?: parseDelimiter(inputString)
    }

    private fun isExistCustomDelimiter(inputString: String): MatchResult? {
        return """//(.)\\n(.*)""".toRegex().find(inputString)
    }

    private fun parseDelimiter(inputString: String): List<String> {
        return inputString.split(",|:".toRegex())
    }


    private fun parseCustomDelimiter(matchResult: MatchResult): List<String> {
        val customDelimiter = matchResult.groupValues[FIND_DELIMITER_INDEX]
        val temp = matchResult.groupValues[TARGET_DATA_INDEX].split(customDelimiter)
        return temp
    }

    fun checkNullOrEmpty(inputString: String): String {
        return if (inputString.isNullOrEmpty()) {
            RETURN_ERROR_VALUE
        } else {
            inputString
        }
    }

    companion object {
        const val RETURN_ERROR_VALUE = "0"
        const val FIND_DELIMITER_INDEX = 1
        const val TARGET_DATA_INDEX = 2
    }
}

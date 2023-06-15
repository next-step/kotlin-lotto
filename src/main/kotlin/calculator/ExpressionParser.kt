package calculator

class ExpressionParser() {
    fun isExistCustomDelimiter(inputString: String): MatchResult? {
        val temp = Regex("//(.)\n(.*)").find(inputString)
        println(temp)
        return temp
    }

    fun parseDelimiter(inputString: String): List<String> {
        return inputString.split(",|:".toRegex())
    }

    fun parseCustomDelimiter(matchResult: MatchResult): List<String> {
        val customDelimiter = matchResult.groupValues[FIND_DELIMITER_INDEX]
        return matchResult.groupValues[TARGET_DATA_INDEX].split(customDelimiter)
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

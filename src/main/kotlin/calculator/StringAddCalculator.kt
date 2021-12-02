package calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank())
            return 0

        CUSTOM_DELIMITER_REGEX.find(text)?.let {
            val customDelimiter = it.groupValues[1].toRegex()
            return parseToNum(it.groupValues[2], customDelimiter).sum()
        }

        return parseToNum(text).sum()
    }

    private fun parseToNum(text: String, delimiter: Regex = COMMA_AND_COLON_REGEX): List<Int> {
        val stringNums = text.split(delimiter)
        return stringNums.map { convertToInt(it) }
    }

    private fun convertToInt(num: String): Int {
        return when {
            num.isNullOrBlank() -> 0
            num.matches(NUM_REGEX) -> num.toInt()
            else -> throw RuntimeException(INVALID_INPUT_RUNTIME_EXCEPTION)
        }
    }

    companion object {
        val NUM_REGEX = "\\d+".toRegex()
        val COMMA_AND_COLON_REGEX = ",|:".toRegex()
        val CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)".toRegex()
        const val INVALID_INPUT_RUNTIME_EXCEPTION = "음수나 숫자가 아닌 값을 입력할 수 없습니다."
    }
}

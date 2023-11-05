package tdd_string_add_calculator

object Calculator {
    fun calculate(originalExpress: String?): String {
        val express = originalExpress ?: DEFAULT_VALUE
        val customDelimiter = getCustomDelimiterFromExpress(express)
        val newRegex = getRegexWithCustomDelimiter(customDelimiter)
        val customDelimiterString = getCustomDelimiterString(
            express = express,
            customDelimiter = customDelimiter
        )
        val newExpress = getNewExpress(
            express = express,
            customDelimiter = customDelimiter,
            customDelimiterString = customDelimiterString
        )
        val list = newExpress.split(newRegex)
        return calculate(list)
    }

    private fun getCustomDelimiterFromExpress(express: String): String =
        if (express.startsWith(CUSTOM_DELIMITER_START_WITH)) {
            express.getOrNull(CUSTOM_DELIMITER_INDEX).toString()
        } else {
            EMPTY_STRING
        }

    private fun getRegexWithCustomDelimiter(customDelimiter: String) = "([${SPLIT_REGEX + customDelimiter}])".toRegex()

    /**
     * CustomDelimiter 가 존재 안하면 기존 express,
     * CustomDelimiter 가 존재 하면 전달 받은 customDelimiterString 을 잘라서 express 만 남김
     */
    private fun getNewExpress(
        express: String,
        customDelimiter: String,
        customDelimiterString: String
    ): String = if (customDelimiter.isBlank()) express else express.replace(customDelimiterString, EMPTY_STRING)

    /**
     * custom delimiter 만 찾기
     */
    private fun getCustomDelimiterString(express: String, customDelimiter: String): String =
        if (customDelimiter.isNotBlank()) (express.substring(FIRST_SUBSTRING_RANGE..LAST_SUBSTRING_RANGE)) else express

    private fun calculate(list: List<String>): String {
        return runCatching {
            list.map { string ->
                val number = changeLettersToNumber(string)
                validateNumberIsNegativeNumber(number)
            }.reduce { acc, i -> acc + i }
                .toString()
        }.getOrElse { throw RuntimeException() }
    }

    private fun changeLettersToNumber(it: String): Int = it.ifBlank { DEFAULT_VALUE }.toInt()

    private fun validateNumberIsNegativeNumber(number: Int) =
        if (number < MINIMUM_NUMBER) throw RuntimeException() else number

    private const val EMPTY_STRING = ""
    private const val CUSTOM_DELIMITER_START_WITH = "/"
    private const val CUSTOM_DELIMITER_INDEX = 2
    private const val MINIMUM_NUMBER = 0
    private const val FIRST_SUBSTRING_RANGE = 0
    private const val LAST_SUBSTRING_RANGE = 3
    private const val SPLIT_REGEX = ",:"
    private const val DEFAULT_VALUE = "0"
}

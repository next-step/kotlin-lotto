package calculate

object CustomDelimiter {
    private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")
    private const val CUSTOM_DELIMITER_PREFIX = "//"
    private const val DELIMITER_INDEX = 1
    private const val VALUES_INDEX = 2

    fun isCustomDelimiter(text: String): Boolean {
        return text.startsWith(CUSTOM_DELIMITER_PREFIX)
    }

    fun parse(text: String): List<String> {
        val result = CUSTOM_DELIMITER_PATTERN.find(text) ?: throw NullPointerException("커스텀구분자를 찾을 수 없습니다")

        return result.groupValues[VALUES_INDEX].split(result.groupValues[DELIMITER_INDEX])
    }
}

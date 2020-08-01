private const val DELIMITER_PATTERN = "//(.)\\\\n"
private const val DELIMITER_CHARACTER_POSITION = 2
class Calculator {
    fun existDelimiter(content: String): Boolean {
        val regex = Regex(pattern = DELIMITER_PATTERN)
        return regex.containsMatchIn(content)
    }

    fun getDelimiters(content: String): List<String> {
        val regex = Regex(pattern = DELIMITER_PATTERN)
        val find = regex.find(content)

        checkNotNull(find) {
            return DEFAULT_DELIMITERS
        }

        return DEFAULT_DELIMITERS + find.value[DELIMITER_CHARACTER_POSITION].toString()
    }

    companion object {
        @JvmField
        val DEFAULT_DELIMITERS = listOf(":", ",")
    }
}

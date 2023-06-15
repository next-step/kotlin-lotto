class StringAddCalculator {
    fun add(text: String?): Int {
        if (text == null || text.trim().isEmpty()) return 0

        val delimiters = mutableListOf<String>()
            .apply { addAll(DEFAULT_DELIMITERS) }

        if (existCustomizedDelimiter(text)) {
            delimiters.apply { addAll(getCustomizedDelimiter(text)) }
            return calculate(getTrimmedText(text), delimiters)
        }

        return calculate(text, delimiters)
    }

    private fun existCustomizedDelimiter(text: String): Boolean {
        return text.indexOf("//") == 0 && text.indexOf("\n") != -1
    }

    private fun getCustomizedDelimiter(text: String): List<String> {
        val startIndex = text.indexOf(CUSTOM_DELIMITER_START_FLAG) + CUSTOM_DELIMITER_START_FLAG.length
        val endIndex = text.indexOf(CUSTOM_DELIMITER_END_FLAG, startIndex)
        return text.substring(startIndex, endIndex)
            .map{ it.toString() }
            .onEach { char ->
                runCatching {
                    require(!char.equals(MINUS_OPERATOR)) { }
                }.getOrElse {
                    throw RuntimeException(it)
                }
            }
    }

    private fun getTrimmedText(text: String): String {
        return text.substring(text.indexOf(CUSTOM_DELIMITER_END_FLAG) + CUSTOM_DELIMITER_END_FLAG.length)
    }

    private fun calculate(text: String, delimiters: List<String> ): Int {
        val numStringList = text.split(*delimiters.toTypedArray())
        return numStringList.sumOf { numberConverter(it) }
    }

    private fun numberConverter(text: String): Int {
        val number = text.toIntOrNull()
        if (number == null || number < 0) {
            throw RuntimeException()
        }
        return number
    }

    companion object {
        private const val CUSTOM_DELIMITER_START_FLAG = "//"
        private const val CUSTOM_DELIMITER_END_FLAG = "\n"
        private const val MINUS_OPERATOR = "-"
        private val DEFAULT_DELIMITERS = listOf(",",":")
    }
}
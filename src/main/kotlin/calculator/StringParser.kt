package calculator

class StringParser {
    fun parsingNumbers(text: String): List<Long> {
        val result = CUSTOM_DELIMITER_REGEX.find(text)
        result?.let {
            val customDelimiter = it.groupValues[DELIMITER_INDEX]
            return it.groupValues[EXPRESSION_INDEX].split(customDelimiter)
                .map { v -> toPositiveNumber(v) }
        }

        return parsingWithDefaultDelimiter(text)
    }

    private fun parsingWithDefaultDelimiter(text: String): List<Long> {
        return text.split(DEFAULT_DELIMITER_REGEX)
            .map { v -> toPositiveNumber(v) }
    }

    private fun toPositiveNumber(s: String): Long {
        require(s.toLongOrNull() != null) { "숫자가 아닙니다. [$s]" }
        require(s.toLong() > -1) { "0 이상의 숫자여야 합니다. [$s]" }
        return s.toLong()
    }

    companion object {
        private const val DELIMITER_INDEX = 1
        private const val EXPRESSION_INDEX = 2
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}

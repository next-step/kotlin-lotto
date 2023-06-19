package calculate

class StringAddCalculator {
    fun add(text: String?): Any {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val startIndex = text.indexOf(CUSTOM_DELIMITER_PREFIX)
        val endIndex = text.indexOf(CUSTOM_DELIMITER_SUFFIX)

        val result = if (hasCustomDelimiter(startIndex, endIndex)) {
            val customDelimiter = text.substring(startIndex + CUSTOM_DELIMITER_PREFIX.length, endIndex)
            text.substring(endIndex + 1).split(customDelimiter)
        } else {
            text.split(",", ":")
        }.sumOf { it.toInt() }

        require(result >= 0) {
            "결과는 0 이상이어야 합니다."
        }

        return result
    }

    private fun hasCustomDelimiter(startIndex: Int, endIndex: Int) = startIndex >= 0 && endIndex >= 0 && (startIndex + CUSTOM_DELIMITER_PREFIX.length) < endIndex

    companion object {
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\n"
    }
}

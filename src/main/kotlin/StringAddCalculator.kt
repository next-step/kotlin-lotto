class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        if (text.contains("-")) {
            throw RuntimeException("음수는 사용할 수 없습니다")
        }
        val (plainText, customSeparator) = separateCustomSeparatorWithText(text)
        val replacedOperator = replaceToSameSeparator(plainText, customSeparator)
        val numbers = replacedOperator.split(COMMON_SEPARATOR).map { it.toInt() }
        return numbers.sum()
    }

    private fun replaceToSameSeparator(text: String, customSeparator: String?): String {
        var replacedOperator = text
        if (customSeparator != null) {
            replacedOperator = replacedOperator.replace(customSeparator, COMMON_SEPARATOR)
        }
        DEFAULT_SEPARATORS.forEach {
            replacedOperator = replacedOperator.replace(it, COMMON_SEPARATOR)
        }
        return replacedOperator
    }

    private fun separateCustomSeparatorWithText(text: String): Pair<String, String?> {
        if (!text.startsWith(CUSTOM_SEPARATOR_START)) {
            return Pair(text, null)
        }
        val firstIndex = CUSTOM_SEPARATOR_START.length
        val lastIndex = text.indexOf(CUSTOM_SEPARATOR_END)
        val customSeparator = text.substring(firstIndex, lastIndex)
        val plainText = text.substring(lastIndex + CUSTOM_SEPARATOR_END.length)
        return Pair(plainText, customSeparator)
    }

    companion object {
        private const val CUSTOM_SEPARATOR_START = "//"
        private const val CUSTOM_SEPARATOR_END = "\n"
        private const val COMMON_SEPARATOR = ","
        private val DEFAULT_SEPARATORS = arrayListOf(",", ":")
    }
}

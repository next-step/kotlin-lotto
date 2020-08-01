package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (isBlank(text)) return 0

        text?.let {
            checkNegative(it)

            if (justOneNumber(it)) return it.toInt()
            return sum(it)
        }

        return 0
    }

    private fun isBlank(text: String?): Boolean = text.isNullOrBlank()

    private fun checkNegative(text: String) {
        if (text.contains('-')) throw RuntimeException(NOT_ALLOW_NEGATIVE)
    }

    private fun justOneNumber(text: String): Boolean {
        text.forEach { if (!it.isDigit()) return false }
        return true
    }

    private fun sum(text: String): Int {
        if (hasCustomDelimiter(text)) return customSum(text)
        return defaultSum(text)
    }

    private fun hasCustomDelimiter(text: String): Boolean {
        Regex(CUSTOM_PATTERN).find(text) ?: return false
        return true
    }

    private fun customSum(text: String): Int {
        val result = Regex(CUSTOM_PATTERN).find(text)!!

        val customDelimiter = result.groupValues[1]
        val tokens = result.groupValues[2].split(customDelimiter)

        return tokens.sumBy { it.toInt() }
    }

    private fun defaultSum(text: String): Int {
        val tokens = text.split(DELIMITER_COMMA, DELIMITER_COLON)

        return tokens.sumBy { it.toInt() }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val CUSTOM_PATTERN = "//(.)\n(.*)"
        private const val NOT_ALLOW_NEGATIVE = "음수 입력 불가"
    }
}

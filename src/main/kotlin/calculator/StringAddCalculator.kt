package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (isBlank(text)) return 0

        text?.let {
            checkNegative(it)

            if (justOneNumber(it)) return it.toInt()
            return defaultSum(it)
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

    private fun defaultSum(text: String): Int {
        val tokens = text.split(DELIMITER_COMMA, DELIMITER_COLON)

        return tokens.sumBy { it.toInt() }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val NOT_ALLOW_NEGATIVE = "음수 입력 불가"
    }
}

package string.add.calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val tokens = split(text)
        return tokens
            .map { it.toInt() }
            .sum()
    }

    private fun split(text: String): List<String> {
        val regex = CUSTOM_DELIMITER.toRegex()
        val matchResult = regex.matchEntire(text)
        if (matchResult != null) {
            val (delimiter, numbers) = matchResult.destructured
            return numbers.split(delimiter)
        }
        return text.split(COMMA, COLON)
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}

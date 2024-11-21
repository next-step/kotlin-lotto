package stringcalculator

class StringCalculator {
    fun sum(exp: String): Int {
        return if (exp.startsWith(CUSTOM_SEPARATOR_START_SYMBOL)) {
            val customSeparator = getCustomSeparator(exp)
            splitAndSum(exp.substringAfter(CUSTOM_SEPARATOR_END_SYMBOL), customSeparator)
        } else {
            splitAndSum(exp, COMMA, COLON)
        }
    }

    private fun splitAndSum(
        exp: String,
        vararg separators: String,
    ): Int {
        return exp.split(*separators)
            .sumOf { token ->
                token.toIntOrNull()?.takeIf { it >= 0 } ?: throw RuntimeException()
            }
    }

    private fun getCustomSeparator(exp: String): String {
        return exp.split(CUSTOM_SEPARATOR_START_SYMBOL, CUSTOM_SEPARATOR_END_SYMBOL).getOrNull(CUSTOM_SEPARATOR_INDEX)
            ?: throw RuntimeException()
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val CUSTOM_SEPARATOR_START_SYMBOL = "//"
        private const val CUSTOM_SEPARATOR_END_SYMBOL = "\n"
        private const val CUSTOM_SEPARATOR_INDEX = 1
    }
}

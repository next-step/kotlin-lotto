class Calculator {

    fun calculate(formula: String): Int {
        if (formula.isBlank()) {
            return 0
        }
        val numbers = formulaParser(formula)

        return numbers.sum()
    }

    private fun formulaParser(formula: String): List<Int> {
        val result = REGEX.find(formula)
        val tokens = result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: run {
            formula.split(*DEFAULT_DELIMITER)
        }

        return parseToInt(tokens)
    }

    private fun parseToInt(tokens: List<String>): List<Int> {
        return tokens.map { parseValidation(it) }
    }

    private fun parseValidation(token: String): Int {
        try {
            val parseToken = token.toInt()
            require(parseToken >= 0)

            return parseToken
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("자연수로 변환하는데 실패했습니다.")
        }
    }

    companion object {
        private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
        val REGEX = Regex(CUSTOM_DELIMITER_REGEX)
        val DEFAULT_DELIMITER = arrayOf(",", ":")
    }
}

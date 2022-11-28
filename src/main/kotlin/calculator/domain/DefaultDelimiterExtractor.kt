package calculator.domain

class DefaultDelimiterExtractor : DelimiterExtractor {
    override fun extract(expression: String): List<Long> {
        return DEFAULT_SEPARATOR_REGEX
            .split(expression)
            .map { it.toLong() }
    }

    override fun isValidExpression(expression: String): Boolean {
        return EXPRESSION_VALID_REGEX.matches(expression)
    }

    companion object {
        val EXPRESSION_VALID_REGEX = "^[,:\\d]*$".toRegex()
        val DEFAULT_SEPARATOR_REGEX = ",|:".toRegex()
    }
}

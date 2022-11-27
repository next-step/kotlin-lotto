package calculator.domain

import java.lang.IllegalArgumentException

class CustomDelimiterExtractor : DelimiterExtractor {
    override fun extract(text: String): List<Long> {
        val matchResult = CUSTOM_SEPARATOR_REGEX.find(text)
            ?: throw IllegalArgumentException("커스텀 구분자가 포함된 양식에 맞지 않는 수식이에요.")

        val customDelimiter = matchResult.groupValues[SEPARATOR_INDEX]
        val expression = matchResult.groupValues[EXPRESSION_INDEX]

        return expression
            .split(customDelimiter)
            .map { it.toLong() }
    }

    override fun isValidExpression(expression: String): Boolean {
        return CUSTOM_SEPARATOR_REGEX.matches(expression)
    }

    companion object {
        private val CUSTOM_SEPARATOR_REGEX = Regex("//(.)\n(.*)")
        private const val SEPARATOR_INDEX = 1
        private const val EXPRESSION_INDEX = 2
    }
}

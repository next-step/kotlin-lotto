package expressioncalculator

import expressioncalculator.model.Delimiter
import expressioncalculator.model.Expression
import expressioncalculator.model.ExpressionInput

object InputConverter {
    private const val CUSTOM_DELIMITER_REGEX_PATTERN = "//(.)\n(.*)"
    private val customDelimiterRegex = CUSTOM_DELIMITER_REGEX_PATTERN.toRegex()

    fun convert(input: String): ExpressionInput {
        val customDelimiterMatchResult = customDelimiterRegex.find(input)

        return customDelimiterMatchResult.toExpressionInput(input)
    }

    private fun MatchResult?.toExpressionInput(input: String): ExpressionInput {
        return this?.destructured?.let { (delimiter, expression) ->
            ExpressionInput(
                expression = Expression(expression),
                delimiter = Delimiter(delimiter)
            )
        } ?: ExpressionInput.from(Expression(input))
    }
}

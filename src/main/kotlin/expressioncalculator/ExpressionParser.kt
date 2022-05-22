package expressioncalculator

import expressioncalculator.model.Delimiter
import expressioncalculator.model.Expression
import expressioncalculator.model.ExpressionInput

object ExpressionParser {
    fun parse(expressionInput: ExpressionInput): List<Int> {
        return expressionInput.let { (expression, delimiter) ->
            expression
                .toStringNumbers(delimiter)
                .toIntNumbers()
        }
    }

    private fun Expression.toStringNumbers(delimiter: Delimiter) = if (value.isBlank()) {
        listOf()
    } else {
        value.split(delimiter.value)
    }

    private fun List<String>.toIntNumbers() = map { stringNumber ->
        IntValidator.validate(stringNumber.toIntOrNull())
    }
}

package expressioncalculator

import expressioncalculator.model.Delimiter
import expressioncalculator.model.Expression
import expressioncalculator.model.ExpressionInput

object ExpressionParser {
    fun parse(expressionInput: ExpressionInput): List<Int> = expressionInput.expression
        .toStringNumbers(expressionInput.delimiter)
        .toIntNumbers()

    private fun Expression.toStringNumbers(delimiter: Delimiter): List<String> = if (value.isBlank()) {
        listOf()
    } else {
        value.split(delimiter.value)
    }

    private fun List<String>.toIntNumbers(): List<Int> = map { stringNumber ->
        IntValidator.validate(stringNumber.toIntOrNull())
    }
}

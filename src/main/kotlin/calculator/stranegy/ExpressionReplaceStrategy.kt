package calculator.stranegy

import calculator.domain.Expression
import calculator.domain.SplitTerms

enum class ExpressionReplaceStrategy(
    val split: (Expression, SplitTerms) -> Expression
) {

    CALCULATOR_PLUS({ expression, splitTerms ->
        var expressionReplace = expression.value

        splitTerms.value.forEach { terms ->
            expressionReplace = expressionReplace.replace(terms, SPLIT_RESULT)
        }

        Expression(expressionReplace)
    });

    companion object {
        private const val SPLIT_RESULT = ""
    }

}
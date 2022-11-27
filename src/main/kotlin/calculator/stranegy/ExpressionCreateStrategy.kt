package calculator.stranegy

import calculator.domain.Expression
import calculator.domain.SplitTerms
import calculator.extensions.removeCustomRegex

enum class ExpressionCreateStrategy(
    val create: (String, SplitTerms) -> Expression
) {

    CALCULATOR_PLUS({ input, splitTerms ->
        var expressionReplace = input.removeCustomRegex()

        splitTerms.value.forEach { terms ->
            expressionReplace = expressionReplace.replace(terms, SPLIT_RESULT)
        }

        Expression(expressionReplace)
    });

    companion object {
        private const val SPLIT_RESULT = ""
    }

}
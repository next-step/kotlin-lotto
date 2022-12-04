package calculator.domain

import calculator.util.RegexUtil.customRegex

class Expression private constructor(
    val value: List<ExpressionElement> = emptyList()
) {

    companion object {
        fun create(input: String, delimiters: Delimiters): Expression {
            if (input.isEmpty()) {
                return Expression(emptyList())
            }

            val value = removeCustomRegex(input)
                .asSequence()
                .map { char ->
                    if (char.isDigit()) {
                        ExpressionElement.OperandElement(char.digitToInt())
                    } else {
                        ExpressionElement.OperatorElement(delimiters.toOperator(char.toString()))
                    }
                }.toList()

            return Expression(value)
        }

        private fun removeCustomRegex(text: String): String {
            if (customRegex.matches(text)) {
                return customRegex.find(text)
                    ?.run { groupValues[2] }
                    .toString()
            }
            return text
        }
    }
}

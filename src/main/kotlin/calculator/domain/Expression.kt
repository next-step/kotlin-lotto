package calculator.domain

import calculator.extensions.isNumeric
import calculator.extensions.split
import calculator.util.validate

class Expression private constructor(
    val value: List<ExpressionElement> = emptyList()
) {

    fun fetchOperands(): List<Int> {
        return value.filterIsInstance<ExpressionElement.OperandElement>().map { it.value }
    }

    fun fetchOperators(): List<Operator> {
        return value.filterIsInstance<ExpressionElement.OperatorElement>().map { it.value }
    }

    companion object {

        private const val MESSAGE_NOT_POSITIVE_NUMBER = "양수가 아닌 숫자를 전달 받을 수 없습니다."
        private const val MESSAGE_NOT_OPERAND = "피연산자만 들어올 수 있습니다."

        fun create(input: String, delimiters: Delimiters): Expression {
            if (input.isEmpty()) {
                return Expression()
            }

            val text = delimiters.removeCustomRegex(input)
            val splitDelimiters = text.split(delimiters.value)
            val lastIndex = splitDelimiters.size - 1

            val expressionElements = mutableListOf<ExpressionElement>()

            splitDelimiters.mapIndexed { index, it ->
                if (it.isNumeric().not()) throw IllegalArgumentException(MESSAGE_NOT_OPERAND)

                val digit = it.toInt()

                val isNotNegativeNumber = digit > -1
                validate(isNotNegativeNumber) { MESSAGE_NOT_POSITIVE_NUMBER }

                expressionElements.add(ExpressionElement.OperandElement(digit))
                if (index != lastIndex) {
                    expressionElements.add(ExpressionElement.OperatorElement(Operator.PLUS))
                }
            }

            return Expression(expressionElements.toList())
        }
    }
}

package calculator.domain

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

        fun create(input: String, delimiters: Delimiters): Expression {
            if (input.isEmpty()) {
                return Expression()
            }

            val value = delimiters.removeCustomRegex(input)
                .map {
                    if (it.isDigit()) {
                        val digit = it.digitToInt()

                        val isNotNegativeNumber = digit > -1
                        validate(isNotNegativeNumber) { MESSAGE_NOT_POSITIVE_NUMBER }

                        ExpressionElement.OperandElement(digit)
                    } else {
                        ExpressionElement.OperatorElement(delimiters.toOperator(it.toString()))

                    }
                }


            return Expression(value)
        }
    }
}

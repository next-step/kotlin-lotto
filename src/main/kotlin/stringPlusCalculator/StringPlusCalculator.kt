package stringPlusCalculator

import stringPlusCalculator.exception.BlankExpressionInputException

class StringPlusCalculator {
    companion object {
        fun calculate(expressionInput: String): Int {
            val parsedOperands = arrayListOf<String>()

            return try {
                validateBlankExpressionInput(expressionInput)

                CustomStringParser.parse(expressionInput)
                    .map { operand -> operand }
                    .map { operand -> parsedOperands.addAll(BasicStringParser.parse(operand)) }

                return StringInputConverter.convert(parsedOperands).sum()
            } catch (e: BlankExpressionInputException) {
                0
            }
        }

        private fun validateBlankExpressionInput(expressionInput: String) {
            if (expressionInput.isNullOrBlank()) throw BlankExpressionInputException("입력값이 비었습니다.")
        }
    }
}

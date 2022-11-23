package stringPlusCalculator

import stringPlusCalculator.exception.BlankExpressionInputException
class StringPlusCalculator {
    companion object {
        fun calculate(expressionInput: String): Int {
            return try {
                if(expressionInput.isNullOrBlank()) throw BlankExpressionInputException("입력값이 비었습니다.")

                val parsedOperands = arrayListOf<String>()

                CustomStringParser().parse(expressionInput).map { operand ->
                    operand
                }.map { operand ->
                    parsedOperands.addAll(BasicStringParser().parse(operand))
                }

                StringInputConverter.convert(parsedOperands).sum()
            } catch (e: BlankExpressionInputException) {
                0
            }
        }
    }
}
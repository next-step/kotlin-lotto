package calculator.domain

import calculator.util.SplitUtil.splitExpressionToInts

class Calculator(private val expression: Expression) {

    fun calculate(): Int {
        var result = 0

        splitExpressionToInts(expression).forEach { number ->
            result = result.plus(number)
        }

        return result
    }

}
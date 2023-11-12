package camp.nextstep.edu.step.step1.domain.calculator

import camp.nextstep.edu.step.step1.domain.amount.FinalResult

/**
 * @description : 계산식에서 나온 계산식을 토대로 계산을 진행하는 일급 컬렉션
 */
data class Calculator(
    val expressions: List<String>
) {

    fun calculateExpression(): FinalResult {
        var midResult = 0

        for(expression in expressions) {
         midResult = midResult.plus(expression.toInt())
        }

        return FinalResult(amount = midResult)
    }

    companion object {
        fun of(expressions: List<String>): Calculator {
            return Calculator(expressions)
        }
    }

}

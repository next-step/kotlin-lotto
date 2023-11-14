package camp.nextstep.edu.step.step1.domain.calculator

import camp.nextstep.edu.step.step1.domain.amount.FinalResult

/**
 * @description : 계산식에서 나온 계산식을 토대로 계산을 진행하는 일급 컬렉션
 */
data class Calculator(
    val expressions: List<String>
) {

    fun calculateExpression(): FinalResult {

        val result = expressions.reduce { midResult, expression ->
            val result = midResult.toInt() + expression.toInt()
            result.toString()
        }

        return FinalResult(amount = result.toInt())
    }

}

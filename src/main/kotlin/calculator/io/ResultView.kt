package calculator.io

import calculator.domain.Expression

object ResultView {
    fun printResult(expression: Expression) {
        println("식 계산 결과 : ${expression.getSum()}")
    }
}

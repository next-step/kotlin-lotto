package step1.calculator

import step1.calculator.domain.Expression

class StringCalculator {
    companion object {
        fun calculate(input: String): Int {
            return Expression.of(input).sum()
        }
    }
}

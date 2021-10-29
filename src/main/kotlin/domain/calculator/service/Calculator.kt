package domain.calculator.service

import domain.calculator.domain.operand.PositiveOperands
import domain.calculator.domain.expression.Expression
import domain.calculator.domain.result.CalculateResult
import domain.calculator.domain.separator.Separators

object Calculator {
    fun calculate(expression: Expression): CalculateResult {
        val separators = Separators.of(expression)
        val operands = expression.split(separators.separators)
        val positiveOperands = PositiveOperands.of(operands)
        return CalculateResult(positiveOperands.sum())
    }
}

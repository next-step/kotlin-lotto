package calculator.application.calculator.factory

import calculator.application.calculator.Calculator
import calculator.application.calculator.impl.StandardCalculator
import calculator.domain.operation.AdditionBinaryOperation
import calculator.domain.operation.BinaryOperation

object CalculatorFactory {
    fun generate(): Calculator = StandardCalculator(additionOperation = addOperation())
    private fun addOperation(): BinaryOperation = AdditionBinaryOperation
}

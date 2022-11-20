package calculator.application.calculator.impl

import calculator.application.calculator.Calculator
import calculator.common.model.PositiveInteger
import calculator.domain.operation.BinaryOperation
import calculator.domain.operation.BinaryOperationCommand

class StandardCalculator(
    private val additionOperation: BinaryOperation
) : Calculator {

    override fun multiplePlus(numbers: List<PositiveInteger>): Int {
        var result = 0
        for (number in numbers) {
            result = plus(result, number.value)
        }
        return result
    }

    private fun plus(firstNumber: Int, secondNumber: Int): Int {
        val command = BinaryOperationCommand(leftArgument = firstNumber, rightArgument = secondNumber)
        return additionOperation.operate(command)
    }
}

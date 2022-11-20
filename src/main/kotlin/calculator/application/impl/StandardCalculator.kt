package calculator.application.impl

import calculator.application.Calculator
import calculator.domain.operation.BinaryOperation
import calculator.domain.operation.BinaryOperationCommand

class StandardCalculator(
    private val additionOperation: BinaryOperation
) : Calculator {

    override fun plus(firstNumber: Int, secondNumber: Int): Int {
        val command = BinaryOperationCommand(leftArgument = firstNumber, rightArgument = secondNumber)
        return additionOperation.operate(command)
    }
}

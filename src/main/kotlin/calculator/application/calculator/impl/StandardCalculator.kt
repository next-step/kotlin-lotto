package calculator.application.calculator.impl

import calculator.application.calculator.Calculator
import calculator.common.model.PositiveInteger
import calculator.common.model.PositiveIntegers
import calculator.domain.operation.BinaryOperation
import calculator.domain.operation.BinaryOperationCommand

class StandardCalculator(
    private val additionOperation: BinaryOperation
) : Calculator {

    override fun multiplePlus(numbers: PositiveIntegers): Int {
        return numbers.multiplePlus(plusFunction).value
    }

    private val plusFunction: (PositiveInteger, PositiveInteger) -> PositiveInteger =
        fun (firstNumber: PositiveInteger, secondNumber: PositiveInteger): PositiveInteger {
            val command = BinaryOperationCommand(leftArgument = firstNumber, rightArgument = secondNumber)
            return PositiveInteger(additionOperation.operate(command))
        }
}

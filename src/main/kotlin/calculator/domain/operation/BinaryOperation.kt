package calculator.domain.operation

import calculator.common.model.PositiveInteger

sealed interface BinaryOperation : Operation<BinaryOperationCommand> {
    override fun operate(command: BinaryOperationCommand): Int
}

class BinaryOperationCommand(
    val leftArgument: PositiveInteger,
    val rightArgument: PositiveInteger
) : OperationCommand

object AdditionBinaryOperation : BinaryOperation {
    override fun operate(command: BinaryOperationCommand): Int {
        return command.leftArgument.value + command.rightArgument.value
    }
}

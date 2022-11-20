package calculator.domain.operation

sealed interface BinaryOperation : Operation<BinaryOperationCommand> {
    override fun operate(command: BinaryOperationCommand): Int
}

class BinaryOperationCommand(
    val leftArgument: Int,
    val rightArgument: Int
) : OperationCommand

object AdditionBinaryOperation : BinaryOperation {
    override fun operate(command: BinaryOperationCommand): Int {
        return command.leftArgument + command.rightArgument
    }
}

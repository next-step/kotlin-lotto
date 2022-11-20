package calculator.domain.operation

sealed interface Operation<in T : OperationCommand> {
    fun operate(command: T): Int
}

interface OperationCommand

package calculator

import calculator.Operand.Companion.toOperand

typealias Calculator = (leftOperand: Operand, rightOperand: Operand) -> Operand

enum class Operation(val symbol: String, val calculator: Calculator) {
    PLUS(
        "+",
        { leftOperand, rightOperand -> (leftOperand.value + rightOperand.value).toOperand() }
    );
}

@JvmInline
value class CustomOperation(val symbol: String)

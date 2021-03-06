package stringadder.domain

fun createOperands(vararg operands: String) = Operands(operands.map { Operand(it) })
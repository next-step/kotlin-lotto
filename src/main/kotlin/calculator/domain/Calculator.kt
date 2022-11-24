package calculator.domain

object Calculator {
    fun add(positiveOperands: Array<PositiveOperand>): PositiveOperand {
        return PositiveOperand(positiveOperands.sumOf { it.value })
    }
}

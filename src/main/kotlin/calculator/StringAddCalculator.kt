package calculator

import java.lang.RuntimeException

class StringAddCalculator(
    private val validation: OperandValidation
) {

    fun add(input: String?): Operand =
        if (input.isNullOrBlank()) Operand.ZERO
        else StringSpliterator.split(input).map(::toOperand).sum()

    private fun toOperand(string: String): Operand = Operand.valueOf(string).let {
        if (validation.check(it)) throw RuntimeException("음수는 입력하실 수 없습니다.")
        else it
    }
}

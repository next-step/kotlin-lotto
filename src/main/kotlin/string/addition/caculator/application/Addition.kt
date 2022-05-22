package string.addition.caculator.application

import string.addition.caculator.domain.Operand

class Addition(private val operands: List<Operand>) {
    fun result(): Int =
        operands.fold(0) { acc, operand -> operand.number?.plus(acc) ?: acc }
}

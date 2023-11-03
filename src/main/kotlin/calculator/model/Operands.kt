package calculator.model

import calculator.messages.ErrorMessages.INVALID_NUMBER_INPUT_EXCEPTION

class Operands(private val operands: List<Int>) {

    fun calculate(): Int {
        return operands.sum()
    }

    companion object {
        fun from(operands: List<String>): Operands {
            return Operands(
                operands.map {
                    val result = it.toInt()
                    require(result > 0) { throw RuntimeException(INVALID_NUMBER_INPUT_EXCEPTION.message) }
                    result
                }.toList()
            )
        }
    }
}

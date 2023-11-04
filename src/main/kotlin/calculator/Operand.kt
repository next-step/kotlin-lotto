package calculator

class Operand(
    private val value: String
) {
    init {
        validateOperand()
    }

    fun getValue(): Int {
        return value.toInt()
    }

    private fun validateOperand() {
        validateIsNumber()
        validateIsPositive()
    }

    private fun validateIsNumber() {
        if (value.toIntOrNull() == null) {
            throw RuntimeException("수식에 숫자가 아닌 값이 포함되어 있습니다.")
        }
    }

    private fun validateIsPositive() {
        if (value.toInt() < 0) {
            throw RuntimeException("수식에 음수가 포함되어 있습니다.")
        }
    }
}

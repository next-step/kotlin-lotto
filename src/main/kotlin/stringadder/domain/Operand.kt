package stringadder.domain

class Operand(number: String) {
    var operand: Int

    init {
        validateNumber(number)
        operand = number.toInt()
    }

    private fun validateNumber(number: String) {
        try {
            validatePositive(number.toInt())
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자만 입력할 수 있습니다.")
        }
    }

    private fun validatePositive(number: Int) {
        require(number >= MIN_NUMBER) { "$MIN_NUMBER 이상의 숫자만 입력할 수 있습니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operand

        if (operand != other.operand) return false

        return true
    }

    override fun hashCode(): Int {
        return operand
    }

    companion object {
        private const val MIN_NUMBER = 0
    }
}

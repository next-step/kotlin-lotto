package stringadder.domain

class OperandNumber(number: String) {
    private var operandNumber: Int

    init {
        validateNumber(number)
        operandNumber = number.toInt()
    }

    private fun validateNumber(number: String) {
        try {
            validatePositive(number.toInt())
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자만 입력할 수 있습니다.")
        }
    }

    private fun validatePositive(number: Int) {
        require(number >= MIN_NUMBER) { "0 이상의 숫자만 입력할 수 있습니다." }
    }

    companion object {
        private const val MIN_NUMBER = 0
    }
}
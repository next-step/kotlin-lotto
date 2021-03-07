package stringadder.domain

data class Operand(private val token: String) {
    val operand: Int

    init {
        val number = token.toInt()
        validateNumber(number)
        operand = number
    }

    private fun validateNumber(number: Int) {
        try {
            validatePositive(number)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력할 수 있습니다.")
        }
    }

    private fun validatePositive(number: Int) {
        require(number >= MIN_NUMBER) { "$MIN_NUMBER 이상의 숫자만 입력할 수 있습니다." }
    }

    companion object {
        private const val MIN_NUMBER = 0
    }
}

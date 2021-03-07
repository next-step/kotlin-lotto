package stringadder.domain

data class Operand(private val token: String) {
    val operand: Int = validateNumber(token)

    private fun validateNumber(token: String): Int {
        try {
            val number = token.toInt()
            validatePositive(number)
            return number
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

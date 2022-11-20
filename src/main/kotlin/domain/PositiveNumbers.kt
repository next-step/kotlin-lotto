package domain

class PositiveNumbers(private val numbers: List<Int> = listOf()) {
    fun sum(): Int {
        return if (this.numbers.isEmpty()) {
            ZERO
        } else {
            numbers.sum()
        }
    }

    companion object {
        private const val ZERO = 0
        private const val ILLEGAL_ARGUMENT_EXCEPTION_ERROR_MESSAGE = "유효하지 않은 숫자입니다."

        @JvmStatic
        fun from(tokens: List<String>): PositiveNumbers {
            return PositiveNumbers(
                tokens.map {
                    convertStringToInt(it)
                }
            )
        }

        private fun convertStringToInt(value: String): Int {
            val number = value.toIntOrNull()
                ?: throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_ERROR_MESSAGE)
            return PositiveNumber(number).value
        }
    }
}

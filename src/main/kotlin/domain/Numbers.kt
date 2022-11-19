package domain

import java.lang.RuntimeException

class Numbers(private val numbers: List<Int> = listOf()) {
    fun sum(): Int {
        return if (this.numbers.size == ZERO) {
            ZERO
        } else {
            numbers.sum()
        }
    }

    companion object {
        private const val ZERO = 0
        private const val RUNTIME_EXCEPTION_ERROR_MESSAGE = "숫자는 음수일 수 없습니다."
        private const val ILLEGAL_ARGUMENT_EXCEPTION_ERROR_MESSAGE = "유효하지 않은 숫자입니다."

        @JvmStatic
        fun from(tokens: List<String>): Numbers {
            return Numbers(
                tokens.map {
                    convertStringToInt(it)
                }
            )
        }

        private fun convertStringToInt(value: String): Int {
            val number = value.toIntOrNull()
                ?: throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_ERROR_MESSAGE)
            validateNotNegative(number)
            return number
        }

        private fun validateNotNegative(value: Int) {
            if (value < ZERO) {
                throw RuntimeException(RUNTIME_EXCEPTION_ERROR_MESSAGE)
            }
        }
    }
}

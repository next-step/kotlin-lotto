package domain

import java.lang.RuntimeException

@JvmInline
value class PositiveNumber(private val number: Int) {
    val value: Int
        get() = number

    init {
        if (number < ZERO) {
            throw RuntimeException(RUNTIME_EXCEPTION_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val ZERO = 0
        private const val RUNTIME_EXCEPTION_ERROR_MESSAGE = "숫자는 음수일 수 없습니다."
    }
}

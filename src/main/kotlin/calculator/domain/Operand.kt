package calculator.domain

import java.lang.RuntimeException

@JvmInline
value class Operand(val value: Int) {

    companion object {
        private val pattern = Regex("-?\\d+")
        private const val MIN_VALUE = 0

        val ZERO = Operand(MIN_VALUE)

        private fun verify(value: String) {
            require(pattern.matches(value)) { "유효한 형식의 피연산자가 아닙니다." }
            if (value.toInt() < MIN_VALUE) throw RuntimeException("음수를 입력할 수 없습니다.")
        }

        fun of(value: String?): Operand {
            if (value.isNullOrEmpty()) return ZERO
            verify(value)
            return Operand(value.toInt())
        }
    }
}

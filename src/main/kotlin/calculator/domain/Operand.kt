package calculator.domain

import java.lang.RuntimeException

@JvmInline
value class Operand(val value: Int) {

    companion object {
        private val pattern = Regex("-?\\d+")

        val ZERO = Operand(0)

        private fun verify(value: String) {
            require(pattern.matches(value)) { "유효한 형식의 피연산자가 아닙니다." }
            if (value.toInt() < 0) throw RuntimeException("음수를 입력할 수 없습니다.")
        }

        fun of(value: String?): Operand {
            if (value.isNullOrEmpty()) return ZERO
            verify(value)
            return Operand(value.toInt())
        }
    }
}

package calculator

import java.lang.RuntimeException

class StringAddCalculator(
    private val validation: NumberValidation
) {

    fun add(input: String?): Int =
        if (input.isNullOrBlank()) DEFAULT_VALUE
        else StringSpliterator.split(input).sumOf(::getNumber)

    private fun getNumber(string: String): Int = Operand.valueOf(string).let {
        if (validation.check(it.number)) throw RuntimeException("음수는 입력하실 수 없습니다.")
        else it.number
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}

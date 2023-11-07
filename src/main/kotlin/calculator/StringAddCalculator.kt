package calculator

import java.lang.RuntimeException

class StringAddCalculator(
    private val validation: NumberValidation
) {

    private val stringToIntConvert: (String) -> Int = {
        runCatching { it.toInt() }
            .onFailure { throw RuntimeException("정수와 구분자만 입력하여 주세요.") }
            .getOrThrow()
    }

    fun add(input: String?): Int =
        if (input.isNullOrBlank()) DEFAULT_VALUE
        else StringSpliterator.split(input).sumOf(::getNumber)

    private fun getNumber(string: String): Int = stringToIntConvert(string).let {
        if(validation.check(it)) throw RuntimeException("음수는 입력하실 수 없습니다.")
        else it
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}

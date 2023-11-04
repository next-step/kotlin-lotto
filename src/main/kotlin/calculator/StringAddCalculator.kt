package calculator

import java.lang.RuntimeException

class StringAddCalculator (
    private val validation: NumberValidation,
    private val stringToInt: StringToIntConverter
) {

    fun add(input: String?): Int =
        if (input.isNullOrBlank()) 0
        else StringSpliterator.split(input).sumOf(::getNumber)

    private fun getNumber(string: String) : Int {
        val number = stringToInt.convert(string)
        return when (validation.check(number)) {
            true -> throw RuntimeException("음수는 입력하실 수 없습니다.")
            false -> number
        }
    }
}

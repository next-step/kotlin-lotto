package calculator

import java.lang.RuntimeException

class StringAddCalculator (
    private val spliterator: Spliterator<String>,
    private val validation: NumberValidation
) {

    fun add(input: String?): Int {
        require(input != null && input != "") { return 0 }
        return spliterator.split(input).sumOf(::getNumber)
    }

    private fun getNumber(string: String) : Int =
        when (val number = string.toIntOrNull()) {
            null -> throw RuntimeException("정수와 구분자만 입력하여 주세요.")
            else -> when (validation.check(number)) {
                true -> throw RuntimeException("음수는 입력하실 수 없습니다.")
                false -> number
            }
        }
}

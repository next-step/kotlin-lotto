package calculator

import java.lang.RuntimeException

data class Number(private val string: String) {
    val number = makeNumber()

    init {
        checkMinus()
    }

    private fun makeNumber(): Int {
        try {
            return string.toInt()
        }catch (e: Exception) {
            throw RuntimeException("숫자 이외의 값이 있습니다.")
        }
    }

    private fun checkMinus() {
        if (number < 0) {
            throw RuntimeException("음수값은 계산 할수없습니다.")
        }
    }
}
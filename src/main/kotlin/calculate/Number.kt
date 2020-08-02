package calculate

import java.lang.RuntimeException

class Number(number: String) {
    val value: Int = getNumber(number)

    private fun getNumber(text: String): Int {
        try {
            val number = text.toInt()

            require(number > CALCULATOR_MIN_NUMBER) { "${CALCULATOR_MIN_NUMBER}보다 큰 숫자만 더할 수 있습니다." }

            return number
        } catch (e: RuntimeException) {
            throw RuntimeException("숫자만 더할 수 있습니다.")
        }
    }

    companion object {
        private const val CALCULATOR_MIN_NUMBER = 0
    }
}

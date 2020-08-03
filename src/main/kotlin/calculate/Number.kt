package calculate

import java.lang.RuntimeException

private const val CALCULATOR_MIN_NUMBER = 0

class Number(number: String) {
    init {
        try {
            if (number.toInt() <= CALCULATOR_MIN_NUMBER) throw RuntimeException("${CALCULATOR_MIN_NUMBER}보다 큰 숫자만 더할 수 있습니다.")
        } catch (e: RuntimeException) {
            throw RuntimeException("숫자만 더할 수 있습니다.")
        }
    }

    val value: Int = number.toInt()
}

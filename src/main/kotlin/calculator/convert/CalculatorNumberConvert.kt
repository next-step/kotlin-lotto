package calculator.convert

import kotlin.math.sign

object CalculatorNumberConvert {
    private val EXCEPTION_MESSAGE = "음수는 더 할 수 업습니다."

    fun convertInt(target: String): Int {
        val convertedNumber: Int
        try {
            convertedNumber = Integer.parseInt(target)
        } catch (ex: NumberFormatException) {
            throw IllegalStateException("$target 은 숫자 가 아닙니다.")
        }
        validateNegative(convertedNumber)
        return positiveNumber(convertedNumber)
    }

    private fun positiveNumber(target: Int): Int {
        require(target >= 0) { "$target 은 양수가 아닙니다." }
        return target
    }

    private fun validateNegative(convertedNumber: Int) {
        when {
            convertedNumber and Int.MIN_VALUE != 0 -> throw RuntimeException(EXCEPTION_MESSAGE)
            convertedNumber.sign < 0 -> throw RuntimeException(EXCEPTION_MESSAGE)
            convertedNumber < 0 -> throw RuntimeException(EXCEPTION_MESSAGE)
        }
    }
}

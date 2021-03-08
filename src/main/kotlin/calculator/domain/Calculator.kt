package calculator.domain

import java.lang.NumberFormatException
import java.lang.RuntimeException

class Calculator {

    fun calculate(numbers: List<String>): Int {
        var sum = 0
        for (number in numbers) {
            checkValidateNumber(number)
            checkNegativeNumber(number)
            sum += number.toInt()
        }

        return sum
    }

    private fun checkValidateNumber(string: String) {
        try {
            string.toInt()
        }catch (e: NumberFormatException) {
            throw RuntimeException("$string 은 올바른 숫자가 아닙니다.")
        }
    }

    private fun checkNegativeNumber(string: String) {
        if(string.toInt() < 0) throw RuntimeException("음수는 계산식에 포함될 수 없습니다.")
    }
}

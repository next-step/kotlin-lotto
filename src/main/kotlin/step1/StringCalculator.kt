package step1

import java.lang.RuntimeException


private const val DEFAULT_RETURN_VALUE = 0

class StringCalculator {
    companion object {

        fun calculate(input: String?): Int {
            if (input.isNullOrEmpty()) return DEFAULT_RETURN_VALUE

            val numberList = StringParser.splitBySeparator(input).map {
                it.toIntOrNull() ?: throw RuntimeException("계산식에 숫자 이외의 값을 입력할 수 없습니다. 입력값 : $it")
            }.map {
                it < 0 && throw RuntimeException("계산식에 음수를 입력할 수 없습니다. 입력값 : $it")
                it
            }

            return numberList.sum()
        }


    }
}
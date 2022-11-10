package step1

import java.lang.RuntimeException

private const val CUSTOM_SEPARATOR_FIND_REGEX = "//(.)\n(.*)"

class StringCalculator {
    companion object {
        private val DEFAULT_SEPARATOR = "[,:]".toRegex()
        fun calculate(input: String?): Int {
            if (input.isNullOrEmpty()) return 0
            val numberList = splitBySeparator(input).map {
                it.toIntOrNull() ?: throw RuntimeException("계산식에 숫자 이외의 값을 입력할 수 없습니다. 입력값 : $it")
            }.map {
                it < 0 && throw RuntimeException("계산식에 음수를 입력할 수 없습니다. 입력값 : $it")
                it
            }

            return numberList.sum()
        }

        private fun splitBySeparator(input: String) = Regex(CUSTOM_SEPARATOR_FIND_REGEX).find(input)?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: input.split(DEFAULT_SEPARATOR)
    }
}
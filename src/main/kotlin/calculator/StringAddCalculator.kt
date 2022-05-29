package calculator

import java.lang.RuntimeException

class StringAddCalculator {
    fun calculate(inputStr: String?): Long {
        if (inputStr.isNullOrBlank()) {
            return 0L
        }
        if (inputStr.length == 1) {
            return inputStr.toLong()
        }
        return sumWhenCustomDelimiterExist(inputStr) ?: sumWhenDefaultDelimiterExist(inputStr)
    }

    private fun sumWhenCustomDelimiterExist(inputStr: String): Long? {
        return Regex("//(.)\n(.*)").find(inputStr)
            ?.let {
                val customDelimiter = it.groupValues[1]
                val numbers = it.groupValues[2].split(customDelimiter)
                    .map { it.toLong() }
                    .map { number ->
                        if (number < 0) throw RuntimeException("계산기는 양수만 계산할 수 있어요. 계산기가 전달받은 값은 $inputStr 에요.")
                        number
                    }
                numbers.sum()
            }
    }

    private fun sumWhenDefaultDelimiterExist(inputStr: String): Long {
        val numbers = inputStr.split(",|:".toRegex())
            .map { it.toLong() }
            .map { number ->
                if (number < 0) throw RuntimeException("계산기는 양수만 계산할 수 있어요. 계산기가 전달받은 값은 $inputStr 에요.")
                number
            }
        return numbers.sum()
    }
}

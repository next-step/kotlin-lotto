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
                    .map { numberStr -> isNumeric(numberStr.toLongOrNull()) }
                numbers.sum()
            }
    }

    private fun sumWhenDefaultDelimiterExist(inputStr: String): Long {
        val numbers = inputStr.split(",|:".toRegex())
            .map { numberStr -> isNumeric(numberStr.toLongOrNull()) }
        return numbers.sum()
    }

    private fun isNumeric(number: Long?): Long {
        if (number == null || number < 0) {
            throw RuntimeException("계산기는 0보다 큰 숫자만 계산할 수 있어요. 값을 확인해주세요. $number")
        }
        return number
    }
}
}

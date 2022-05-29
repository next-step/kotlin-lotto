package calculator

class StringAddCalculator {
    fun calculate(inputStr: String?): Long {
        if (inputStr.isNullOrBlank()) {
            return 0L
        }
        return sumWhenCustomDelimiterExist(inputStr) ?: sumWhenDefaultDelimiterExist(inputStr)
    }

    private fun sumWhenCustomDelimiterExist(inputStr: String): Long? {
        return Regex("//(.)\n(.*)").find(inputStr)
            ?.let {
                val customDelimiter = it.groupValues[1]
                val numbers = it.groupValues[2].split(customDelimiter)
                    .map { numberStr -> Numbers.isNumericLong(numberStr) }
                numbers.sum()
            }
    }

    private fun sumWhenDefaultDelimiterExist(inputStr: String): Long {
        val numbers = inputStr.split(",|:".toRegex())
            .map { numberStr -> Numbers.isNumericLong(numberStr) }
        return numbers.sum()
    }
}

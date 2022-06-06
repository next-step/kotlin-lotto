package calculator

class StringAddCalculator {
    fun calculate(inputStr: String?): Long {
        if (inputStr.isNullOrBlank()) {
            return 0L
        }
        return sumWhenCustomDelimiterExist(inputStr) ?: sumWhenDefaultDelimiterExist(inputStr)
    }

    private fun sumWhenCustomDelimiterExist(inputStr: String): Long? {
        return REGEX_CUSTOM_DELIMITER.find(inputStr)
            ?.let {
                val customDelimiter = it.groupValues[1]
                it.groupValues[2].split(customDelimiter)
                    .sumOf { numberStr -> numberStr.toNumericLong() }
            }
    }

    private fun sumWhenDefaultDelimiterExist(inputStr: String): Long {
        return inputStr.split(",|:".toRegex())
            .sumOf { numberStr -> numberStr.toNumericLong() }
    }

    companion object {
        private val REGEX_CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
    }
}

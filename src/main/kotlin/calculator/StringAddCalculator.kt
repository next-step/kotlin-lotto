package calculator

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

    private fun sumWhenDefaultDelimiterExist(inputStr: String): Long {
        val numbers = inputStr.split(",|:".toRegex()).map { it.toLong() }
        return numbers.sum()
    }

    private fun sumWhenCustomDelimiterExist(inputStr: String): Long? {
        return Regex("//(.)\n(.*)").find(inputStr)
            ?.let {
                val customDelimiter = it.groupValues[1]
                val numbers = it.groupValues[2].split(customDelimiter).map { it.toLong() }
                numbers.sum()
            }
    }
}

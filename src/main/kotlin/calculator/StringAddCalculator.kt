package calculator

class StringAddCalculator {
    fun calculate(inputStr: String?): Long {
        if (inputStr.isNullOrBlank()) {
            return 0L
        }
        if (inputStr.length == 1) {
            return inputStr.toLong()
        }
        val numbers = inputStr.split(",|:".toRegex()).map { it.toLong() }
        return numbers.sum()
    }
}
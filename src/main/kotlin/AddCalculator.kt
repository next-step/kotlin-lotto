object AddCalculator {

    private const val DELIMITERS = ",|:"

    fun add(expression: String?): Int {
        require(!expression.isNullOrBlank())
        return sumOfNumbers(extractNumbers(expression))
    }

    private fun sumOfNumbers(nums: List<Int>) = nums.sum()

    private fun extractNumbers(expression: String): List<Int> {
        return if (expression.startsWith("//")) {
            extractNumbersWithCustomDelimiter(expression)
        } else {
            return expression.split(DELIMITERS.toRegex()).map { nonNegativeNumber(it) }
        }
    }

    private fun extractNumbersWithCustomDelimiter(expression: String): List<Int> {
        val matchResult = Regex("//(.)\n(.*)").find(expression)
        return matchResult?.let { result ->
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(customDelimiter).map { nonNegativeNumber(it) }
        } ?: throw IllegalArgumentException()
    }

    private fun nonNegativeNumber(text: String): Int {
        if (text.startsWith("-")) throw RuntimeException()
        return text.toInt()
    }
}

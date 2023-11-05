package calculator

object AddCalculator {

    fun add(expression: String?): Int {
        require(!expression.isNullOrBlank())
        return sumOfNumbers(extractNumbers(expression))
    }

    private fun sumOfNumbers(nums: List<Int>) = nums.sum()

    private fun extractNumbers(expression: String): List<Int> {
        return getExtractor(expression).extractNumbers()
    }

    private fun getExtractor(expression: String): NumberExtractor {
        return when {
            expression.startsWith("//") -> CustomNumberExtractor(expression)
            else -> DefaultNumberExtractor(expression)
        }
    }
}

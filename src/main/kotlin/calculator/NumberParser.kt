package calculator

class NumberParser(private val delimiterStrategies: List<DelimiterStrategy>) {

    fun parseNumbers(input: String): List<Int> {
        return when {
            isSingleNumber(input) -> listOf(input.toInt())
            else -> parseWithStrategy(input)
        }
    }

    private fun isSingleNumber(input: String): Boolean {
        return input.matches(DelimiterConstants.SINGLE_NUMBER_PATTERN)
    }

    private fun parseWithStrategy(input: String): List<Int> {
        return delimiterStrategies.firstOrNull { it.supports(input) }
            ?.parse(input)
            ?: throw IllegalArgumentException("적절한 구분자를 찾을 수 없습니다")
    }
}

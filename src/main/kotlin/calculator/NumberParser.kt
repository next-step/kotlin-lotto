package calculator

class NumberParser {
    private val delimiterStrategies = listOf(
        CustomDelimiterStrategy(),
        DefaultDelimiterStrategy()
    )

    fun parse(text: String): List<Int> {
        return when {
            text.length == 1 -> listOf(text.toInt())
            else -> parseWithStrategy(text)
        }
    }

    private fun parseWithStrategy(text: String): List<Int> {
        return delimiterStrategies.firstOrNull { it.supports(text) }
            ?.parse(text)
            ?: throw IllegalArgumentException("적절한 구분자를 찾을 수 없습니다")
    }
}

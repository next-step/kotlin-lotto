package calulator

import calulator.delimiterParser.CustomDelimiterStrategy
import calulator.delimiterParser.DefaultDelimiterStrategy

object Parser {

    private val parseStrategy = listOf(
        CustomDelimiterStrategy(),
        DefaultDelimiterStrategy(),
    )

    fun parse(text: String): Numbers {
        if (text.isBlank()) {
            return Numbers(emptyList())
        }

        val strategy = parseStrategy.firstOrNull { it.support(text) }
            ?: throw RuntimeException("잘못된 입력입니다.")

        val numbers = strategy.parse(text)
        return Numbers(numbers)
    }
}

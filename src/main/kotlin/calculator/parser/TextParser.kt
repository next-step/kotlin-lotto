package calculator.parser

import calculator.PositiveNumber
import calculator.delimiter.CustomDelimiterSplitter
import calculator.delimiter.DefaultDelimiterSplitter
import calculator.delimiter.DelimiterSplitter

object TextParser {
    private val delimiterSplitters =
        listOf(CustomDelimiterSplitter, DefaultDelimiterSplitter)
            .sortedBy(DelimiterSplitter::priority)
    private val DEFAULT_VALUE = listOf<PositiveNumber>()

    fun parse(input: String?): List<PositiveNumber> {
        if (input.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val delimiterSplitter =
            delimiterSplitters.sortedBy(DelimiterSplitter::priority)
                .firstOrNull { it.isSupport(input) }
                ?: throw IllegalArgumentException("해당 입력을 처리할 수 없습니다.")

        return delimiterSplitter.split(input).map { PositiveNumber(it.toInt()) }
    }
}

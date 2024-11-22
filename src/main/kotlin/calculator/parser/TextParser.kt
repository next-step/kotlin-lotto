package calculator.parser

import calculator.delimiter.DefaultDelimiterSplitter
import calculator.delimiter.DelimiterSplitter

class TextParser(
    private val delimiterSplitters: List<DelimiterSplitter>,
) {
    fun parse(input: String?): List<Int> {
        if (input.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val delimiterSplitter = delimiterSplitters.firstOrNull { it.isSupport(input) } ?: DefaultDelimiterSplitter
        return delimiterSplitter.split(input).map(String::toInt)
    }

    companion object {
        private val DEFAULT_VALUE = listOf<Int>()
    }
}

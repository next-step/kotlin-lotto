package calculator

import calculator.separator.CustomDelimiterSeparator
import calculator.separator.DefaultCustomDelimiterSeparator
import calculator.vo.Delimiter
import calculator.vo.Delimiters
import calculator.vo.NonNegativeInteger

class StringAddCalculator(
    private val customDelimiterSeparator: CustomDelimiterSeparator = DefaultCustomDelimiterSeparator,
) {
    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }
        val (customDelimiter, separatedInput) = customDelimiterSeparator.separateFrom(input)

        val delimiters = DEFAULT_DELIMITERS.add(customDelimiter)

        val numbers = DelimiterBasedTokenizer
            .tokenize(separatedInput, delimiters)
            .map(NonNegativeInteger.Companion::from)

        return numbers.sumOf { it.value }
    }

    companion object {
        private val DEFAULT_DELIMITERS = Delimiters.from(listOf(Delimiter(':'), Delimiter(',')))
    }
}

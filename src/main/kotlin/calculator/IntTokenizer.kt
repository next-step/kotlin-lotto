package calculator

import calculator.vo.Delimiter
import calculator.vo.Delimiters

object IntTokenizer {
    private val DEFAULT_DELIMITERS = Delimiters.from(listOf(Delimiter(':'), Delimiter(',')))
    private val CUSTOM_DELIMITER_SEARCH_PATTERN = Regex("""//(.)\\n(.*)""")

    fun tokenize(input: String): List<Int> {
        val (customDelimiter, separatedInput) = separateCustomDelimiterFrom(input)

        val customizedDelimiters = DEFAULT_DELIMITERS.add(customDelimiter)

        return customizedDelimiters
            .split(separatedInput)
            .map { it.toInt() }
    }

    private fun separateCustomDelimiterFrom(input: String): Pair<Delimiter?, String> {
        val searchResult = CUSTOM_DELIMITER_SEARCH_PATTERN.find(input) ?: return null to input

        val delimiter = Delimiter(searchResult.groupValues[1].toCharArray()[0])
        val separatedInput = searchResult.groupValues[2]

        return delimiter to separatedInput
    }
}


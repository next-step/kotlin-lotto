package stringcalculator.domain

class StringCalculator(
    private val delimiterExtractor: DelimiterExtractor = DelimiterExtractor,
    private val numberParser: NumberParser = NumberParser(),
) {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val (delimitersRegex, numbersPart) = delimiterExtractor.extract(input)
        val numbers = numberParser.parse(numbersPart, delimitersRegex)
        return numbers.sumOf { it.getValue() }
    }
}

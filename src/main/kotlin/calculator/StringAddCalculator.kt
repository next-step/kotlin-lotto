package calculator

class StringAddCalculator(
    private val stringParser: StringParser = StringParser(),
    private val converter: Converter = Converter(),
) {
    fun add(text: String): Int {
        if (text.isBlank()) return 0

        val numbers =
            stringParser.split(text)
                .map { converter.toPositiveNumber(it) }

        return numbers.sum()
    }
}

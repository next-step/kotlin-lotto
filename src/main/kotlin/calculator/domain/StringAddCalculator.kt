package calculator.domain

class StringAddCalculator(
    private val numberExtractor: NumberExtractor = NumberExtractor()
) {
    fun calculate(text: String?): Int {
        val tokens = numberExtractor.extract(text)
        return if (tokens.isEmpty()) 0 else tokens.sumOf { it.toInt() }
    }
}

package calculator

class StringAddCalculator(
    private val numberExtractor: NumberExtractor = NumberExtractor()
) {
    fun add(text: String?): Int {
        val tokens = numberExtractor.extract(text)
        return if (tokens.isEmpty()) 0 else tokens.sumOf { it.toInt() }
    }
}

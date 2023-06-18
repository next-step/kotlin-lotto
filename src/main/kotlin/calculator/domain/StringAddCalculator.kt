package calculator.domain

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val separator = Separator.create(text)
        val separators = Separators()
        separators.add(separator)

        val splitData = TokenizedExpression.generate(text.substringAfter("\n"), separators)
        return splitData.mapNotNull { it.toIntOrNull() }.sum()
    }
}

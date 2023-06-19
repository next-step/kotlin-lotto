package calculator.domain

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val splitData = TokenizedExpression.generate(text)
        return splitData.mapNotNull { it.toIntOrNull() }.sum()
    }
}

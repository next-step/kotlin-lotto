package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = DelimiterParser(text).extractNumbers()
        return Numbers.from(numbers).sum()
    }
}

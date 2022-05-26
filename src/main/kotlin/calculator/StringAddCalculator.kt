package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return ZERO
        }
        val numbers = TextParsing.textParse(text)
        Validation.validate(numbers)

        return numbers.sum()
    }

    companion object {
        private const val ZERO = 0
    }
}

package stringaddcalculator

object StringAddCalculator {
    private val DIGITS_ONLY_REGEX = Regex("^[0-9]+\$")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (containsOnlyOneNumber(text)) {
            return text.toInt()
        }

        val numbers = NumbersExtractor.extract(text)
        return numbers.sum()
    }

    private fun containsOnlyOneNumber(text: String): Boolean {
        return text.matches(DIGITS_ONLY_REGEX)
    }
}

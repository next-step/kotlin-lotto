package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        validateNoNegativeNumbers(text)

        if (containsOnlyOneNumber(text)) {
            return text.toInt()
        }

        val numbers = NumbersExtractor.extract(text)
        return numbers.sum()
    }

    private fun validateNoNegativeNumbers(text: String) {
        if (text.contains(NEGATIVE_NUMBER_REGEX)) {
            throw IllegalArgumentException("음수는 포함될 수 없습니다. 현재 입력 = $text")
        }
    }

    private fun containsOnlyOneNumber(text: String): Boolean {
        return text.matches(DIGITS_ONLY_REGEX)
    }

    companion object {
        private val NEGATIVE_NUMBER_REGEX = Regex("-[0-9]+\$")
        private val DIGITS_ONLY_REGEX = Regex("^[0-9]+\$")
    }
}
package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (containsOnlyOneNumber(text)) {
            return text.toInt()
        }

        val numbers = getNumbers(text)
        return sumAll(numbers)
    }

    private fun containsOnlyOneNumber(text: String): Boolean {
        return text.matches(DIGITS_ONLY_REGEX)
    }

    private fun getNumbers(text: String): List<Int> {
        if (text.contains(CUSTOM_DELIMITER_REGEX)) {
            TODO()
        }

        return text.split(DEFAULT_DELIMITER_REGEX)
            .map { strNumber -> strNumber.toInt() }
    }

    private fun sumAll(numbers: List<Int>): Int {
        return numbers.sum()
    }

    companion object {
        private val DIGITS_ONLY_REGEX = Regex("^[0-9]+\$")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\\n(.*)")
    }
}
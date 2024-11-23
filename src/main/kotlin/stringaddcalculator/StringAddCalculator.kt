package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (containsOnlyOneNumber(text)) {
            return text.toInt()
        }

        return 0
    }

    private fun containsOnlyOneNumber(text: String): Boolean {
        return text.matches(digitsOnlyRegex)
    }

    companion object {
        private val digitsOnlyRegex = Regex("^[0-9]+\$")
    }
}
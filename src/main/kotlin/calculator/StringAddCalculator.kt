package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        text?.let {
            if (containsOnlyDigit(text)) return text.toInt()

            val numbers = InputParser(text).numbersParsed
            return numbers.sum()
        }
        return 0
    }

    private fun containsOnlyDigit(text: String): Boolean = text.all { it.isDigit() }
}

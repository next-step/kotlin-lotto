package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        val text = text!!
        if (containsOnlyDigit(text)) return text.toInt()

        val numbers = Number(text).numbers
        return numbers.sum()
    }

    private fun containsOnlyDigit(text: String): Boolean = text.all { it.isDigit() }
}

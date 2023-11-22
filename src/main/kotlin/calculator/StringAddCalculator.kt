package calculator

object StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (isNumber(text)) {
            return text.toInt()
        }

        val inputNumbers = StringParser().parseString(text)
        return inputNumbers.sum()
    }
}

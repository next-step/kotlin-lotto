package calculator

object StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        val numbers = InputParser.parse(text)
        return numbers.sum()
    }
}

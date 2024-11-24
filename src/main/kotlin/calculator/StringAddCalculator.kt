package calculator

object StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = Numbers(Parser.parseToNumbers(text))
        return numbers.sum()
    }
}

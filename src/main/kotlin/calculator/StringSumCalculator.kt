package calculator

class StringSumCalculator(
    private val parser: Parser = Parser(),
    private val calculator: Calculator = Calculator()
) {
    fun sum(text: String?): Int {
        val numbers = parser.parseNumbers(text)
        return calculator.sum(numbers)
    }
}

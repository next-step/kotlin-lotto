package calculator

object StringCalculator {
    fun add(input: String?): Int {
        val numbers = InputParser.parse(input)
        return numbers.sum
    }
}

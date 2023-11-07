package calculator

class StringCalculator(
    private val inputParser: InputParser,
    private val operator: Operator,
) {
    fun add(input: String): Int {
        val numbers = inputParser.parseInput(input)
        return operator.add(numbers)
    }
}

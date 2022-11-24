package add_calculator

private const val INITIAL_VALUE = 0

class StringAddCalculator(private val inputParser: InputParser) {

    fun calculate(input: String?): Int {
        val operands: List<Operand> = inputParser.parse(input)
        return operands.fold(INITIAL_VALUE) { acc: Int, operand: Operand ->
            operand.add(acc)
        }
    }
}

package add_calculator

class StringAddCalculator(private val inputParser: InputParser) {

    fun calculate(input: String?): Int {
        val operands: List<Operand> = inputParser.parse(input)
        return operands.fold(0) { acc: Int, operand: Operand ->
            operand.add(acc)
        }
    }
}

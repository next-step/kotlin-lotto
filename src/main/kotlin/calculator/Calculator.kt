package calculator

class Calculator(
    private val equationParser:EquationParser = EquationParser
) {

    fun calculate(input: String?): Int {
        val operands = equationParser.parse(input)

        return operands.sum()
    }
}
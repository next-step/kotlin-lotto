package addingCalculator.entity

class CalculatorImpl(override val parser: Parser) : Calculator {
    override fun evaluate(notation: String): Int {
        val parsedNotation = parser.parse(notation)
        val validator = Validator()
        validator.validate(parsedNotation)
        return sumUp(parsedNotation)
    }

    fun sumUp(parsedNotation: List<String>): Int {
        return parsedNotation
            .map { operand: String -> operand.toInt() }
            .reduce { acc, s -> acc + s }.toInt()
    }
}

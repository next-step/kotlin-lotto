package addingCalculator.entity

class CalculatorImpl(override val parser: Parser) : Calculator {
    override fun evaluate(notation: String?): Int {
        val validator = Validator()
        val validNotation = validator.checkNullOrEmpty(notation)
        val parsedNotation = parser.parse(validNotation)

        validator.checkValidNumber(parsedNotation)
        return sumUp(parsedNotation)
    }

    fun sumUp(parsedNotation: List<String>): Int {
        return parsedNotation
            .map { operand: String -> operand.toInt() }
            .reduce { acc, s -> acc + s }.toInt()
    }
}

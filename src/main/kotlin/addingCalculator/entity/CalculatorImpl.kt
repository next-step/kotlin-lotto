package addingCalculator.entity

class CalculatorImpl(override val parser: Parser) : Calculator {
  override fun evaluator(notation: String): Int {
    val parsedNotation = parser.parse(notation)
    Validator().validate(parsedNotation)
    return parsedNotation.map { operand: String -> operand.toInt() }.reduce { acc, s -> acc + s }.toInt()
  }
}
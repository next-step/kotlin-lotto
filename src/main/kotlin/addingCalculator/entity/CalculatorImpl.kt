package addingCalculator.entity

class CalculatorImpl(override val parser: Parser) : Calculator {
  override fun evaluator(notation: String): Int {
    // todo: validate
    val parsedNotation = parser.parse(notation)
    return parsedNotation.reduce { acc, s -> acc+s.toInt() }.toInt()
  }
}
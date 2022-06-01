package addingCalculator.entity

interface Calculator {
  val parser: Parser
  fun evaluator(notation: String): Int?
}
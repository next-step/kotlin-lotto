package addingCalculator.entity

interface Calculator {
    val parser: Parser
    fun evaluate(notation: String): Int?
}

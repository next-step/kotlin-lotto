package addingCalculator.entity

interface Parser {
  fun parse(notation: String): List<Int>
}
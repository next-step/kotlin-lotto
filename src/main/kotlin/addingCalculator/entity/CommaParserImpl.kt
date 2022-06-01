package addingCalculator.entity

class CommaParserImpl : Parser {
  override fun parse(notation: String): List<Int> {
    return notation.split(',').map { it:String -> it.toInt() }
  }
}
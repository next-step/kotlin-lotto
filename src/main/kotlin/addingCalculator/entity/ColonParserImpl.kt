package addingCalculator.entity

class ColonParserImpl : Parser {
  override fun parse(notation: String): List<Int> {
    return notation.split(':').map { it:String -> it.toInt() }
  }
}
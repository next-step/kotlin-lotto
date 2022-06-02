package addingCalculator.entity

class CommaParserImpl : Parser {
  override fun parse(notation: String): List<String> {
    return notation.split(',')
  }
}
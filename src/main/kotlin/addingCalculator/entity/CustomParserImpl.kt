package addingCalculator.entity

class CustomParserImpl : Parser {
  override fun parse(notation: String): List<Int> {
    return Regex("//(.)\n(.*)").find(notation)!!.let {
      it.groupValues[2].split(it.groupValues[1]).map { it:String -> it.toInt() }
    }
  }
}
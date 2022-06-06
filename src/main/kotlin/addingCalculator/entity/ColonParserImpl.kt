package addingCalculator.entity

class ColonParserImpl : Parser {
    override fun parse(notation: String): List<String> {
        return notation.split(':')
    }
}

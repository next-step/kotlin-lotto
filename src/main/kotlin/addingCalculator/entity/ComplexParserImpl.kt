package addingCalculator.entity

class ComplexParserImpl : Parser {
    override fun parse(notation: String): List<String> {
        return notation.split(',', ':')
    }
}

class InputParser {
    fun parse(input: String, delimiterRegex: String): List<String> {
        return input.split(delimiterRegex.toRegex())
    }
}

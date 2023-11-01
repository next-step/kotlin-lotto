package stringcalculator

class StringParser {
    fun parse(input: String, delimiter: String): List<String> {
        return input.split(delimiter)
    }
}

package stringcalculator

class StringParser {
    fun parse(input: String, delimiter: String): List<Int> {
        return input.split(delimiter).map { it.toInt() }
    }
}

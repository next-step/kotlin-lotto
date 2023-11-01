package stringcalculator

class StringParser {
    fun parse(input: String, delimiter: String): List<String> {
        return input.split(delimiter)
    }

    fun parse(input: String): List<String> {
        return input.split(',', ';')
    }

    fun hasCustomDelimiter(input: String): Boolean {
        return input.startsWith("//") && input.contains("\n")
    }
}

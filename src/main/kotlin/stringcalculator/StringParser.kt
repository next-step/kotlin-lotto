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

    fun parseDelimiter(input: String): ParsingData {
        val delimiter = input.substring(2, input.indexOf("\n"))
        val data = input.substring(input.indexOf("\n").plus(1))
        return ParsingData(delimiter, data)
    }
}

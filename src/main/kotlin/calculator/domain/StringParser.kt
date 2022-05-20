package calculator.domain

object StringParser {
    fun parse(value: String, delimiter: String = ";"): List<String> {
        return value.split(delimiter)
    }
}

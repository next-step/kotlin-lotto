package calculator.domain

object Strings {
    fun parse(value: String, delimiter: String = ";"): List<String> {
        return value.split(delimiter)
    }
}

package calculator

class Parser {

    fun parse(expression: String): List<Int> {
        return expression
            .split(*DEFAULT_DELIMITERS.toCharArray())
            .map(String::toInt)
    }

    companion object {
        val DEFAULT_DELIMITERS = listOf(',', ';')
    }
}

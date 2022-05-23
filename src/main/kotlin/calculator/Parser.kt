package calculator

class Parser {

    fun parse(expression: String): List<String> {
        return expression
            .split(*DEFAULT_DELIMITERS.toCharArray())
    }

    companion object {
        val DEFAULT_DELIMITERS = listOf(',', ';')
    }
}

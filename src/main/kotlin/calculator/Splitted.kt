package calculator

data class Splitted(private val elements: List<String>) : List<String> by elements {
    constructor(expression: Expression) : this(expression.syntax, expression.delimiter)
    constructor(string: String, delimiter: String) : this(splitOrEmpty(string, delimiter))

    companion object {
        private fun splitOrEmpty(string: String, delimiter: String) =
            if (string.isEmpty()) emptyList() else string.split(delimiter)
    }
}

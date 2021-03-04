package calculator

data class Splitted(private val elements: List<String>) : List<String> by elements {
    constructor(expression: Expression) : this(expression.syntax(), expression.delimiter)
    constructor(string: String, delimiter: String) : this(string.split(delimiter))
}

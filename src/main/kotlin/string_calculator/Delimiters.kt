package string_calculator

private const val REGEX_OR_SYMBOL = "|"

@JvmInline
value class Delimiters(
    private val value: List<String>,
) {
    fun split(expression: String): StringNumbers {
        val regex = value.joinToString(REGEX_OR_SYMBOL)
        return expression.split(regex.toRegex())
            .map { StringNumber(it) }
            .let { StringNumbers(it) }
    }
}

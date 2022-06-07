package string_calculator

private const val REGEX_OR_SYMBOL = "|"
private val BASIC_DELIMITERS = listOf(",", ":")

@JvmInline
value class Delimiters private constructor(
    val value: List<String> = BASIC_DELIMITERS,
) {
    val size
        get() = value.size

    companion object {
        fun default() = Delimiters(BASIC_DELIMITERS)

        fun instanceOf(delimiter: String) = Delimiters(BASIC_DELIMITERS.plus(delimiter))
    }
}

fun String.splitBy(delimiters: Delimiters): StringNumbers {
    val regex = delimiters.value.joinToString(REGEX_OR_SYMBOL)
    return this.split(regex.toRegex())
        .map { StringNumber(it) }
        .let { StringNumbers(it) }
}

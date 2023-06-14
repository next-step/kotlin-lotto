package calculator

class Calculator(text: String) {

    val separator: String
    val numbers: List<Int>

    init {
        separator = when {
            text.isNullOrBlank() -> ""
            text.contains(",") -> ","
            else -> ":"
        }

        numbers = if (separator.isBlank()) listOf() else text.split(separator).map { it.toInt() }
    }
}
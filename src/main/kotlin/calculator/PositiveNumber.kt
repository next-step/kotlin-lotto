package calculator

@JvmInline
value class PositiveNumber(val value: Int) {

    init {
        require(value >= 0) {
            "$value is not positive number."
        }
    }

    companion object {
        fun of(text: String): PositiveNumber {
            val number = text.toIntOrNull() ?: throw IllegalArgumentException("$text is not number")
            return PositiveNumber(number)
        }
    }
}

fun Iterable<PositiveNumber>.sum(): Int {
    return sumOf { it.value }
}

package math

@JvmInline
value class PositiveNumber(val value: Int) {

    init {
        require(value >= 0) {
            "$value is not positive number."
        }
    }

    operator fun div(other: PositiveNumber): PositiveNumber {
        return PositiveNumber(value / other.value)
    }

    operator fun plus(other: Int): PositiveNumber {
        return PositiveNumber(value + other)
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

fun PositiveNumber?.orZero(): PositiveNumber {
    return this ?: PositiveNumber(0)
}

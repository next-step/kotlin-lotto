package calculator

@JvmInline
value class Number(
    val value: Int
) {
    init { require(value > 0) }

    companion object {
        fun of(value: String): Number = Number(value.toInt())
    }
}

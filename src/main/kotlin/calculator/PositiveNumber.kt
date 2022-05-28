package calculator

class PositiveNumber(private val value: String) {
    val num = value.toIntOrNull() ?: throw IllegalArgumentException()

    init {
        require(num >= 0)
    }

    companion object {
        fun of(value: String): PositiveNumber = PositiveNumber(value)
    }
}

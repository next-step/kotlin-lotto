package calculator

class PositiveNumber(private val value: String) {
    val num = value.toIntOrNull() ?: throw RuntimeException()

    init {
        require(num >= 0)
    }

    companion object {
        fun of(value: String): PositiveNumber = PositiveNumber(value)
    }
}

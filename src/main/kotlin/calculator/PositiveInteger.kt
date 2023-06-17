package calculator

class PositiveInteger(
    val value: Int
) {
    init {
        require(value >= 0)
    }
    operator fun plus(other: PositiveInteger): PositiveInteger = PositiveInteger(value + other.value)
}
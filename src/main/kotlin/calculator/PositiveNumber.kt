package calculator

@JvmInline
value class PositiveNumber(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    operator fun plus(other: PositiveNumber): PositiveNumber {
        return PositiveNumber(value + other.value)
    }
}

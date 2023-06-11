package calculator

@JvmInline
value class PositiveNumber(val value: Int) {

    init {
        require(value > 0) { "음수는 입력될 수 없다" }
    }
}

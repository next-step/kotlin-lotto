package calculator

@JvmInline
value class PositiveNumber(
    private val value: Int
) {
    init {
        require(value >= 0) { "음수는 입력할수 없습니다." }
    }
}

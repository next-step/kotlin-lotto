package calculator.domain

@JvmInline
value class PositiveOperand(val value: Int) {
    init {
        require(value >= ZERO) { "음수는 입력할 수 없습니다." }
    }

    constructor(value: String) : this(
        value.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다.")
    )

    companion object {
        private const val ZERO = 0
    }
}

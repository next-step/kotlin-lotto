package calculator.domain

private const val ZERO = 0

@JvmInline
value class PositiveOperand(val value: Int) {
    init {
        require(value >= ZERO) { "음수는 입력할 수 없습니다." }
    }

    constructor(value: String) : this(
        if (!value.matches(Regex("[0-9]+"))) {
            throw RuntimeException("숫자 이외의 값 또는 음수는 입력할 수 없습니다.")
        } else {
            value.toInt()
        }
    )
}

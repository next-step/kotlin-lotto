package calculator.domain

@JvmInline
value class Term(val value: Int) {
    constructor(input: String) : this(
        input.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
    )

    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }
}

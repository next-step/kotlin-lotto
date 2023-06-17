package calculator.vo

@JvmInline
value class Delimiter(
    private val value: Char,
) {
    init {
        require(value.isDigit().not()) { "숫자는 구분자가 될 수 없습니다." }
    }

    override fun toString(): String {
        return value.toString()
    }
}

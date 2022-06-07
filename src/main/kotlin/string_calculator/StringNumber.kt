package string_calculator

private const val NEGATIVE_NUMBER_STANDARD = 0

@JvmInline
value class StringNumber(
    private val value: Int,
) {
    init {
        require(value >= NEGATIVE_NUMBER_STANDARD) { "문자열 숫자는 음수를 허용하지 않습니다. value = $value" }
    }

    constructor(value: String) : this(value.toInt())

    operator fun plus(other: StringNumber) = StringNumber(this.value + other.value)

    companion object {
        val ZERO = StringNumber(0)
    }
}

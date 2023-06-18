package calculator

@JvmInline
value class PositiveNumber(private val number: Int) {

    constructor(value: String) : this(value.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다."))

    init {
        if (number < 0) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    operator fun plus(other: PositiveNumber): PositiveNumber = PositiveNumber(number + other.number)

    companion object {
        val ZERO = PositiveNumber(0)
    }
}

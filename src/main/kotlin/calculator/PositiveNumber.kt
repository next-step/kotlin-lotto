package calculator

class PositiveNumber(value: Int) {

    private val number = value

    constructor(value: String) : this(value.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다."))

    init {
        if (number < 0) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    operator fun plus(other: PositiveNumber): PositiveNumber = PositiveNumber(number + other.number)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PositiveNumber

        return number == other.number
    }

    override fun hashCode(): Int {
        return number
    }

    override fun toString(): String {
        return "PositiveNumber(number=$number)"
    }

    companion object {
        val ZERO = PositiveNumber(0)
    }
}

package stringaddcalculator.domain

class Number private constructor(val value: Int) {

    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    companion object {
        fun of(input: String): Number {
            try {
                return Number(input.toInt())
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("숫자가 아닌 문자열은 입력할 수 없습니다.")
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }
}

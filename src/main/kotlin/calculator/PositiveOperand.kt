package calculator

data class PositiveOperand(val value: String) {

    init {
        require(value.toIntOrNull() != null) { "숫자가 아닙니다." }
        require(value.toInt() >= MIN_VALUE) { "음수는 사용할 수 없습니다." }
    }

    fun plus(other: PositiveOperand): PositiveOperand {
        return PositiveOperand((value.toInt() + other.value.toInt()).toString())
    }

    fun toInt(): Int = value.toInt()

    companion object {
        private const val MIN_VALUE = 0
    }
}

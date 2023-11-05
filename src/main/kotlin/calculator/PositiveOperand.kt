package calculator

data class PositiveOperand(val value: Int) {

    init {
        require(value >= MIN_VALUE) { "음수는 사용할 수 없습니다." }
    }

    companion object {
        private const val MIN_VALUE = 0
        val ZERO = PositiveOperand(MIN_VALUE)
    }
}

operator fun PositiveOperand.plus(other: PositiveOperand) = PositiveOperand(this.value + other.value)

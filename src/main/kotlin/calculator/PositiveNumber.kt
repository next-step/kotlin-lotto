package calculator

data class PositiveNumber(private val value: Int) {

    operator fun plus(positiveNumber: PositiveNumber): PositiveNumber {
        return this.copy(value = this.value + positiveNumber.value)
    }

    companion object {
        val ZERO = ofString("0")

        fun ofString(value: String): PositiveNumber {
            val positiveNumber = value.toIntOrNull() ?: throw IllegalArgumentException("$value 숫자 이외의 값은 계산 불가능합니다.")
            require(positiveNumber >= 0) { "$value 음수는 생성 불가능 합니다." }

            return PositiveNumber(positiveNumber)
        }
    }
}

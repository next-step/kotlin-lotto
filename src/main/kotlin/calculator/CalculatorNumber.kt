package calculator

data class CalculatorNumber(val value: Int) {
    init {
        require(value >= MIN_NUMBER) {
            "$MIN_NUMBER 이상의 숫자를 입력해야 합니다"
        }
    }

    operator fun plus(other: CalculatorNumber): CalculatorNumber {
        return CalculatorNumber(value + other.value)
    }

    companion object {
        private const val MIN_NUMBER = 0

        fun of(input: String): CalculatorNumber {
            return CalculatorNumber(input.toInt())
        }
    }
}

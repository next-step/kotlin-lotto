package lotto.domain

data class PositiveNumber(val value: Int) {

    init {
        require(value > 0) { "자연수가 아닙니다. value: $value" }
    }

    operator fun minus(other: PositiveNumber): PositiveNumber {
        return PositiveNumber(this.value - other.value)
    }
}

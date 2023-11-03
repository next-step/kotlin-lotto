package lotto.domain

data class Amount(val value: Int) {

    init {
        require(value >= MIN_VALUE) { "음수는 사용할 수 없습니다." }
    }

    companion object {
        private const val MIN_VALUE = 0
    }
}

operator fun Amount.plus(other: Amount) = Amount(this.value + other.value)

operator fun Amount.minus(other: Amount) = Amount(this.value - other.value)

operator fun Amount.div(other: Amount) = Amount(this.value / other.value)

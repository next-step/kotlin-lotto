package lotto.domain

@JvmInline
value class Amount(val value: Int) {

    init {
        require(value >= MIN_VALUE) { "음수는 사용할 수 없습니다." }
    }

    fun divide(amount: Amount): Int {
        require(value % amount.value == 0) { "분배할 수 없는 금액입니다." }

        return value / amount.value
    }

    companion object {
        private const val MIN_VALUE = 0
    }
}

operator fun Amount.plus(other: Amount) = Amount(this.value + other.value)

operator fun Amount.minus(other: Amount) = Amount(this.value - other.value)

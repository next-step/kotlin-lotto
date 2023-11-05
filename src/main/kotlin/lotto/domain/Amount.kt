package lotto.domain

@JvmInline
value class Amount(val value: Int) {

    init {
        require(value >= MIN_VALUE) { "음수는 사용할 수 없습니다." }
    }

    fun exchange(amount: Amount): List<Amount> {
        require(value % amount.value == 0) { "분배할 수 없는 금액입니다." }

        val splitCount = value / amount.value
        return List(splitCount) { amount }
    }

    companion object {
        private const val MIN_VALUE = 0
    }
}

operator fun Amount.plus(other: Amount) = Amount(this.value + other.value)

operator fun Amount.minus(other: Amount) = Amount(this.value - other.value)

operator fun Amount.rem(other: Amount) = this.value % other.value

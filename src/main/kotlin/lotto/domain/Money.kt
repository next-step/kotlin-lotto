package lotto.domain

class Money(val value: Long) {
    init {
        require(value >= MINIMUM_MONEY)
    }

    fun buy(price: Money): Long {
        return this.value / price.value
    }

    companion object {
        private const val MINIMUM_MONEY = 0
    }
}

package lotto.domain

class Money(money: Long) {
    val value: Long = validateMoney(money)

    private fun validateMoney(money: Long): Long {
        require(money >= MINIMUM_MONEY)
        return money
    }

    fun buy(price: Money): Long {
        return this.value / price.value
    }

    companion object {
        private const val MINIMUM_MONEY = 0
    }
}

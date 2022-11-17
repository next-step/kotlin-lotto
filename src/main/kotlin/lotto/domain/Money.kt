package lotto.domain

class Money(money: Long) {
    private val money: Long = validateMoney(money)

    private fun validateMoney(money: Long): Long {
        require(money >= MINIMUM_MONEY)
        return money
    }

    companion object {
        private const val MINIMUM_MONEY = 0
    }
}

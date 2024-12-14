package lotto.domain

data class Amount(val value: Int) {
    init {
        if (isInValidAmount(value)) {
            throw InvalidAmountException(value)
        }
    }

    private fun isInValidAmount(money: Int) = money % MIN_UNIT != 0

    fun validatePurchasable(purchaseCount: Int) {
        val purchaseAmount = purchaseCount * MIN_UNIT
        if (purchaseAmount > value) {
            throw NotEnoughAmountException(purchaseCount)
        }
    }

    fun calculatePurchasableLottoCount(): Int {
        return value / MIN_UNIT
    }

    companion object {
        const val MIN_UNIT = 1000
    }
}

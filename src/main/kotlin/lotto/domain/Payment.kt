package lotto.domain

import lotto.domain.LottoShop.LottoMachine.LOTTO_PRICE

class Payment(money: Int) {
    private var _money = money
    val money: Int
        get() = _money

    init {
        _money = validateAmount(_money)
    }
    fun affordableQuantity() = _money / LOTTO_PRICE

    private fun validateAmount(payment: Int): Int {
        if (LOTTO_PRICE > payment) return NOT_ENOUGH_MONEY
        return this._money
    }
    companion object {
        private const val NOT_ENOUGH_MONEY = 0
    }
}

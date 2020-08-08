package lotto.domain

import lotto.LOTTO_PRICE

class Payment(private var _money: Int) {
    val money: Int
        get() = _money

    init {
        _money = validateAmount(_money)
    }

    private fun validateAmount(payment: Int): Int {
        if (LOTTO_PRICE > payment) return 0
        return this._money
    }
}

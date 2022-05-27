package lotto.domain

import lotto.Const

class LottoPurchase {
    fun getMoney(money: String?): LottoPrice {
        require(!money.isNullOrBlank()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR }
        val moneyToInt = requireNotNull(money.toIntOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR }
        return LottoPrice(moneyToInt)
    }

    fun getLotto(price: LottoPrice) = price.get() / 1000

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

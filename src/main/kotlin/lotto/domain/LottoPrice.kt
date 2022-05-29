package lotto.domain

import lotto.Const

class LottoPrice(
    private val price: Int
) {
    init {
        requireBiggerThanLottoPrice()
    }

    private fun requireBiggerThanLottoPrice() {
        require(price >= LottoPurchase.LOTTO_PRICE) { Const.ErrorMsg.INPUT_VALUE_CANNOT_CONVERSE_LOTTO_PRICE_ERROR_MSG }
    }

    operator fun div(other: Int): Int = this.price / other

    operator fun compareTo(other: Int): Int = this.price.compareTo(other)
}

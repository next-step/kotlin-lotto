package lotto.domain

import lotto.Const

class LottoPrice(
    private val price: PositiveNumber
) {
    init {
        requireBiggerThanLottoPrice()
    }

    private fun requireBiggerThanLottoPrice() {
        require(price.toInt() >= LottoPurchase.LOTTO_PRICE) { Const.ErrorMsg.INPUT_VALUE_CANNOT_CONVERSE_LOTTO_PRICE_ERROR_MSG }
    }

    operator fun div(other: Int): Int = this.price.toInt() / other

    operator fun compareTo(other: Int): Int = this.price.toInt().compareTo(other)

    companion object {
        fun of(price: Int) = LottoPrice(PositiveNumber(price))
    }
}

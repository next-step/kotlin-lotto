package lotto.domain

import lotto.constant.Message

object LottoShop {
    private const val LOTTO_PRICE = 1000
    fun exchangeMoneyForLotto(input: Int): Lotto {
        require (input >= LOTTO_PRICE) { IllegalArgumentException(Message.ILLEGAL_PRICE_MESSAGE) }
        return Lotto(calculate(input))
    }

    fun calculate(input: Int) = input / LOTTO_PRICE
}

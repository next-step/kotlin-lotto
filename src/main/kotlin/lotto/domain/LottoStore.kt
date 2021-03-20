package lotto.domain

import lotto.domain.strategy.NumberGenerateStrategy

object LottoStore {
    const val LOTTO_PRICE = 1000

    fun purchase(amount: String, numberStrategy: NumberGenerateStrategy): LottoTickets {
        val count = PurchaseAmount(amount).amount / LOTTO_PRICE
        return LottoTickets.create(count, numberStrategy)
    }
}

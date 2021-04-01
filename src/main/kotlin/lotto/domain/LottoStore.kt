package lotto.domain

import lotto.domain.strategy.NumberGenerateStrategy

object LottoStore {
    val LOTTO_PRICE = LottoPrice(1000)

    fun purchase(amount: String, numberStrategy: NumberGenerateStrategy): LottoTickets {
        val count = PurchaseAmount(amount) / LOTTO_PRICE
        return LottoTickets.create(count, numberStrategy)
    }
}

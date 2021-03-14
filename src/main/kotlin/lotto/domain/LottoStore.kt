package lotto.domain

import lotto.domain.strategy.NumberGenerateStrategy

class LottoStore {
    fun purchase(amount: String, numberStrategy: NumberGenerateStrategy): LottoTickets {
        val count = PurchaseAmount(amount).amount / LOTTO_PRICE
        return LottoTickets.create(count, numberStrategy)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

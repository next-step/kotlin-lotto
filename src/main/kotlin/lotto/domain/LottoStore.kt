package lotto.domain

import lotto.vo.Money

class LottoStore {
    fun buy(money: Money): LottoBasket {
        val lottoCount = money / LOTTO_PRICE
        val lottos = (1..lottoCount).map { createLotto() }
        return LottoBasket(lottos)
    }

    private fun createLotto(): Lotto {
        return LottoGenerator.generate()
    }

    companion object {
        val LOTTO_PRICE = Money(1000)
    }
}

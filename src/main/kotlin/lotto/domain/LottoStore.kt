package lotto.domain

import lotto.vo.Money

class LottoStore {
    companion object {
        val LOTTO_PRICE = Money(1000)
    }
    fun buy(money: Money): LottoBasket {
        val lottoCount = money / LOTTO_PRICE

        val lottos = mutableListOf<Lotto>()
        repeat((1..lottoCount).count()) {
            lottos.add(createLotto())
        }

        return LottoBasket(lottos)
    }

    private fun createLotto(): Lotto {
        return LottoGenerator.generate()
    }
}

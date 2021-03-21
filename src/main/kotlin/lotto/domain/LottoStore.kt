package lotto.domain

import lotto.vo.Money

class LottoStore {
    fun buy(money: Money): LottoBasket {
        return buy(money, emptyList())
    }

    fun buy(money: Money, manualLottos: List<Lotto>): LottoBasket {
        val autoLottoCount = money / LOTTO_PRICE - manualLottos.size
        val autoLottos = (1..autoLottoCount).map { createLotto() }
        return LottoBasket(autoLottos + manualLottos)
    }

    private fun createLotto(): Lotto {
        return LottoGenerator.generate()
    }

    companion object {
        val LOTTO_PRICE = Money(1000)
    }
}

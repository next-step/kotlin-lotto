package lotto.domain

import lotto.domain.generator.RandomLottoNumberGenerator

object LottoSeller {
    private val LOTTO_COST = Money(1000)

    fun canPurchase(money: Money, manualCount: Int): Boolean {
        val totalCount = calculateCount(money)
        return (totalCount - manualCount) >= 0
    }

    fun buy(money: Money, manualLotto: List<LottoNumbers> = emptyList()): LottoList {
        val count = calculateCount(money)

        val autoCount = count - manualLotto.size
        val autoLotto = LottoMachine.make(autoCount, RandomLottoNumberGenerator)

        return LottoList(manualLotto + autoLotto, LOTTO_COST * count)
    }

    private fun calculateCount(money: Money): Int {
        return money / LOTTO_COST
    }
}

package lotto.domain

import lotto.domain.generator.RandomLottoNumberGenerator

object LottoSeller {
    private val LOTTO_COST = Money(1000)

    fun order(money: Money, manualCount: Int): OrderSheet {
        return OrderSheet(money, manualCount, LOTTO_COST)
    }

    fun take(orderSheet: OrderSheet, manualLotto: List<LottoNumbers> = emptyList()): LottoList {
        val autoLotto = LottoMachine.make(orderSheet.autoCount, RandomLottoNumberGenerator)
        return LottoList(manualLotto + autoLotto, orderSheet.totalCost)
    }
}

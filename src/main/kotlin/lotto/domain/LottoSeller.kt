package lotto.domain

import lotto.domain.generator.RandomLottoNumberGenerator

object LottoSeller {
    private val LOTTO_COST = Money(1000)

    fun order(money: Money, manualCount: Int): OrderSheet {
        return OrderSheet.order(money, manualCount, LOTTO_COST)
    }

    fun take(orderSheet: OrderSheet.Valid, onManual: (count: Int) -> List<LottoNumbers>): LottoList {
        val autoLotto = LottoMachine.make(orderSheet.autoCount, RandomLottoNumberGenerator)
        val manualLotto = onManual(orderSheet.manualCount)
        return LottoList(manualLotto + autoLotto, orderSheet.totalCost)
    }
}

package lotto.domain

import lotto.domain.generator.RandomLottoNumberGenerator

object LottoSeller {
    private val LOTTO_COST = Money(1000)

    fun buy(money: Money): LottoList {
        val count = calculateCount(money)
        return LottoList(LottoMachine.make(count, RandomLottoNumberGenerator), LOTTO_COST * count)
    }

    private fun calculateCount(money: Money): Int {
        return money / LOTTO_COST
    }
}

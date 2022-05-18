package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine

object LottoSeller {
    private val lottoMachine = LottoMachine()

    fun purchaseAuto(money: Long): List<Lotto> {
        val numberOfPurchases = money / LottoMachine.LOTTO_PRICE
        return (1..numberOfPurchases)
            .toList()
            .map { lottoMachine.generateAuto() }
    }
}

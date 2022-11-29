package lotto.service

import lotto.domain.AutoLottoSelector
import lotto.domain.Lotto

private const val UNIT_PRICE = 1000

object LottoPurchaseService {
    fun purchase(payment: Int): List<Lotto> {
        val lottoCount = payment / UNIT_PRICE

        return (1..lottoCount)
            .map { AutoLottoSelector.select() }
    }
}

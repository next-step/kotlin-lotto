package lotto.service

import lotto.domain.AutoLottoSelector
import lotto.domain.Lotto
import lotto.domain.Payment

private const val UNIT_PRICE = 1000

object LottoPurchaseService {
    fun purchase(payment: Payment): List<Lotto> {
        val lottoCount = payment.value / UNIT_PRICE

        return (1..lottoCount)
            .map { AutoLottoSelector.select() }
    }
}

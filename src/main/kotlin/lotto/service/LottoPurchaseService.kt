package lotto.service

import lotto.domain.AutoLottoSelector
import lotto.domain.Lotto
import lotto.domain.ManualLottoSelector
import lotto.domain.Payment

private const val UNIT_PRICE = 1000

object LottoPurchaseService {
    fun purchase(payment: Payment, manualLottos: List<IntArray>): List<Lotto> {
        val lottoCount = payment.value / UNIT_PRICE

        if (manualLottos.size > lottoCount) {
            throw IllegalArgumentException("지불금액이 부족합니다.")
        }

        val selectors = manualLottos.map { ManualLottoSelector(it) } +
            (1..lottoCount - manualLottos.size).map { AutoLottoSelector }

        return selectors.map { it.select() }
    }
}

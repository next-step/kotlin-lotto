package lotto.domain

import lotto.domain.model.LottoResult
import lotto.domain.model.LottoYield
import lotto.domain.model.Money

object LottoYieldCalculator {
    fun calculate(lottoResult: LottoResult, purchaseAmount: Money): LottoYield {
        return LottoYield(lottoResult.getTotalEarns().toDouble() / purchaseAmount.value.toDouble())
    }
}

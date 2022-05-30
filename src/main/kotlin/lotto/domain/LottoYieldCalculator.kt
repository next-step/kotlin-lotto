package lotto.domain

import lotto.domain.model.LottoResult
import lotto.domain.model.LottoYield

object LottoYieldCalculator {
    fun calculate(lottoResult: LottoResult, purchaseAmount: Int): LottoYield {
        return LottoYield(lottoResult.getTotalEarns().toDouble() / purchaseAmount.toDouble())
    }
}

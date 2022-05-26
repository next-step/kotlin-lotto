package lotto.domain

import lotto.domain.model.LottoResult
import lotto.domain.model.Yield

object YieldCalculator {
    fun calculate(lottoResult: LottoResult, purchaseAmount: Int): Yield {
        return Yield(lottoResult.getTotalEarns().toDouble() / purchaseAmount.toDouble())
    }
}

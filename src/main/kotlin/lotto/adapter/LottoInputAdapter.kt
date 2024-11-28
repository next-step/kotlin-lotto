package lotto.adapter

import lotto.domain.LottoBall
import lotto.domain.LottoBalls
import lotto.domain.LottoLine
import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoPurchaseCount

interface LottoInputAdapter {
    fun fetchPurchaseAmount(): LottoPurchaseAmount

    fun fetchManualPurchaseCount(): LottoPurchaseCount

    fun fetchManualLines(manualPurchaseCount: LottoPurchaseCount): List<LottoLine>

    fun fetchWinningNumbers(): LottoBalls

    fun fetchBonusNumber(): LottoBall
}

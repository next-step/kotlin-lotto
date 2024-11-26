package lotto.adapter

import lotto.domain.LottoBall
import lotto.domain.LottoBalls
import lotto.domain.LottoPurchaseAmount

interface LottoInputAdapter {
    fun fetchPurchaseAmount(): LottoPurchaseAmount

    fun fetchWinningNumbers(): LottoBalls

    fun fetchBonusNumber(): LottoBall
}

package lotto.adapter

import lotto.domain.LottoPurchaseAmount

interface LottoInputAdapter {
    fun fetchPurchaseAmount(): LottoPurchaseAmount

    fun fetchWinningNumbers(): List<Int>
}

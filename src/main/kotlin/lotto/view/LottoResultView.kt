package lotto.view

import lotto.domain.shop.LottoPurchaseResult

interface LottoResultView {

    fun display(lottoPurchaseResult: LottoPurchaseResult)
}

package lotto.view

import lotto.domain.shop.LottoShop

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView,
    private val lottoShop: LottoShop,
) {

    fun start() {
        val lottoPurchaseAmount = lottoInputView.readLottoPurchaseAmount()
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchaseAmount)
        lottoResultView.display(lottoPurchaseResult)
    }
}

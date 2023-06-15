package lotto

import lotto.view.input.LottoPurchasePriceInputView
import lotto.view.input.SixFortyFiveLottoLastWinNumInputView
import lotto.view.output.LottoPurchaseOutputView
import lotto.view.output.NewLineOutputView
import lotto.view.output.SixFortyFiveLottoOutputView

fun main() {
    val purchasePrice = LottoPurchasePriceInputView().value
    val purchaseCount = purchasePrice / SixFortyFiveLottoStore.LOTTO_PRICE
    LottoPurchaseOutputView(purchaseCount).renderMessage()

    val lottoStore = SixFortyFiveLottoStore()
    val lottoList = lottoStore.purchase(purchaseCount)
    lottoList.forEach { lotto -> lotto.renderLotto(SixFortyFiveLottoOutputView(lotto)) }
    NewLineOutputView().renderMessage()

    val lastWinningNumber = SixFortyFiveLottoLastWinNumInputView().value
    NewLineOutputView().renderMessage()

    lottoStore.renderWinningInsight(lottoList, lastWinningNumber)
}

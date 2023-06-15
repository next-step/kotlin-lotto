package lotto

import lotto.view.Input.LottoPurchaseOutputView
import lotto.view.Input.LottoPurchasePriceInputView

fun main() {
    val purchasePrice = LottoPurchasePriceInputView().value
    val purchaseCount = purchasePrice / SixFortyFiveLottoStore.LOTTO_PRICE
    LottoPurchaseOutputView(purchaseCount).renderMessage()
}

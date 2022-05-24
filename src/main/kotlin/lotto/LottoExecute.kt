package lotto

import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() {
    val money: Int = LottoInputView.inputLottoPurchase()

    val enableLottoPurchaseCount: Int = LottoSeller.enableSellLottoCount(money)

    val lottoUser = LottoUser()
    lottoUser.purchaseLotto(enableLottoPurchaseCount)
    LottoOutputView.printPurchaseLotto(enableLottoPurchaseCount)
}

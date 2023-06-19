package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoStore
import lotto.view.input.LottoPurchasePriceInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoBonusInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoLastWinNumInputView
import lotto.view.output.LottoPurchaseOutputView
import lotto.view.output.NewLineOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveBonusResultOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveLottoOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveResultOutputView

class SixFortyFiveLottoController(
    val lottoStore: SixFortyFiveLottoStore = SixFortyFiveLottoStore(),
) {
    fun startBonusLotto() {
        val purchasePrice = LottoPurchasePriceInputView().value
        val purchaseCount = lottoStore.getPurchaseCountByPrice(purchasePrice)
        LottoPurchaseOutputView(purchaseCount).renderMessage()

        val lottoList = lottoStore.purchase(purchaseCount)
        SixFortyFiveLottoOutputView(lottoList).renderMessage()

        val lastWinningNumber = SixFortyFiveLottoLastWinNumInputView().value
        NewLineOutputView().renderMessage()
        val bonusWinningNumber = SixFortyFiveLottoBonusInputView().value
        lastWinningNumber.bonusNumber = bonusWinningNumber
        NewLineOutputView().renderMessage()

        SixFortyFiveBonusResultOutputView(lottoList, lastWinningNumber).renderMessage()
    }

    fun startNormalLotto() {
        val purchasePrice = LottoPurchasePriceInputView().value
        val purchaseCount = lottoStore.getPurchaseCountByPrice(purchasePrice)
        LottoPurchaseOutputView(purchaseCount).renderMessage()

        val lottoList = lottoStore.purchase(purchaseCount)
        SixFortyFiveLottoOutputView(lottoList).renderMessage()

        val lastWinningNumber = SixFortyFiveLottoLastWinNumInputView().value
        NewLineOutputView().renderMessage()

        SixFortyFiveResultOutputView(lottoList, lastWinningNumber).renderMessage()
    }
}

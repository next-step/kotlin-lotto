package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoStore
import lotto.view.input.LottoPurchasePriceInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoBonusInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoLastWinNumInputView
import lotto.view.output.LottoPurchaseOutputView
import lotto.view.output.NewLineOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveBonusResultOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveLottoOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveResultOutputView

fun main() {
//    startSixFortyFiveLotto()
    startSixFortyFiveLottoWithBonus()
}

fun startSixFortyFiveLotto() {
    val purchasePrice = LottoPurchasePriceInputView().value
    val purchaseCount = purchasePrice / SixFortyFiveLotto.LOTTO_PRICE
    LottoPurchaseOutputView(purchaseCount).renderMessage()

    val lottoStore = SixFortyFiveLottoStore()
    val lottoList = lottoStore.purchase(purchaseCount)
    SixFortyFiveLottoOutputView(lottoList).renderMessage()

    val lastWinningNumber = SixFortyFiveLottoLastWinNumInputView().value
    NewLineOutputView().renderMessage()

    SixFortyFiveResultOutputView(lottoList, lastWinningNumber).renderMessage()
}

fun startSixFortyFiveLottoWithBonus() {
    val purchasePrice = LottoPurchasePriceInputView().value
    val purchaseCount = purchasePrice / SixFortyFiveLotto.LOTTO_PRICE
    LottoPurchaseOutputView(purchaseCount).renderMessage()

    val lottoStore = SixFortyFiveLottoStore()
    val lottoList = lottoStore.purchase(purchaseCount)
    SixFortyFiveLottoOutputView(lottoList).renderMessage()

    val lastWinningNumber = SixFortyFiveLottoLastWinNumInputView().value
    NewLineOutputView().renderMessage()
    val bonusWinningNumber = SixFortyFiveLottoBonusInputView().value
    lastWinningNumber.bonusNumber = bonusWinningNumber
    NewLineOutputView().renderMessage()

    SixFortyFiveBonusResultOutputView(lottoList, lastWinningNumber).renderMessage()
}

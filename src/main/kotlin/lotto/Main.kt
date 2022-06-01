package lotto

import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val purchasePrice = LottoInputView.purchaseInputView()
    val manualPurchaseCount = LottoInputView.manualPurchaseCountInputView()
    val manualNumbers = LottoInputView.manualLottoNumberInputView(manualPurchaseCount)

    val lottoShop = LottoShop(purchasePrice)
    val manualPurchase = lottoShop.manualPurchase(manualNumbers)
    val autoPurchase = lottoShop.autoPurchase()

    val myLottery = MyLottoTickets(manualPurchase, autoPurchase)

    LottoResultView.printPurchasedLottoInfo(myLottery.manualLottery, myLottery.autoLottery)

    val lastLottoWinnerNumbers = LottoInputView.lastWinnerLotteryInputView()
    val bonusNumber = LottoInputView.bonusNumberInputView()
    val lottoJudgment =
        LastWinningLotto(LottoTicket.of(lastLottoWinnerNumbers.map(LottoNumber::of)), LottoNumber.of(bonusNumber))
    val myLottoResult = myLottery.getMyLottoResult(lottoJudgment)
    val profit = myLottoResult.getProfit()

    LottoResultView.printLottoResult(myLottoResult)
    LottoResultView.printLottoProfilt(profit)
}

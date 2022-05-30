package lotto

import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val purchasePrice = LottoInputView.purchaseInputView()
    val manualPurchaseCount = LottoInputView.manualPurchaseCountInputView()
    val manualNumbers = LottoInputView.manualLottoNumberInputView(manualPurchaseCount)

    val manualPurchase = LottoShop(purchasePrice).manualPurchase(manualNumbers)
    val autoPurchase = LottoShop(purchasePrice).autoPurchase()

    val myLottery = MyLottoTickets(manualPurchase, autoPurchase)

    LottoResultView.printPurchasedLottoInfo(myLottery.manualLottery, myLottery.autoLottery)

    val lastLottoWinnerNumbers = LottoInputView.lastWinnerLotteryInputView()
    val bonusNumber = LottoInputView.bonusNumberInputView()
    val lottoJudgment = LottoJudgment(LottoTicket(lastLottoWinnerNumbers), bonusNumber)
    val myLottoResult = myLottery.getMyLottoResult(lottoJudgment)
    val profit = myLottoResult.getProfit()

    LottoResultView.printLottoResult(myLottoResult)
    LottoResultView.printLottoProfilt(profit)
}

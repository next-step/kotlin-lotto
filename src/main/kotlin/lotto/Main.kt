package lotto

import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val purchasePrice = LottoInputView.purchaseInputView()
    val myLottos = MyLottoTickets(LottoShop().buyLotto(purchasePrice))

    LottoResultView.printPurchasedLottoInfo(myLottos.lottoTickets)

    val lastLottoWinnerNumbers = LottoInputView.lastWinnerLotteryInputView()
    val bonusNumber = LottoInputView.bonusNumberInputView()
    val lottoJudgment = LottoJudgment(LottoTicket(lastLottoWinnerNumbers), bonusNumber)
    val myLottoResult = myLottos.getMyLottoResult(lottoJudgment)
    val profit = myLottos.getProfit(myLottoResult)

    LottoResultView.printLottoResult(myLottoResult)
    LottoResultView.printLottoProfilt(profit)
}

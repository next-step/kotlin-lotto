package lotto

import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val purchasePrice = LottoInputView.purchaseInputView()
    val myLottos = MyLottoTickets(LottoPurchase().buyLotto(purchasePrice))

    LottoResultView.printPurchasedLottoInfo(myLottos.lottoTickets)

    val lastLottoWinnerNumbers = LottoInputView.lastWinnerLotteryInputView()

    val lottoJudgment = LottoJudgment(LottoTicket(lastLottoWinnerNumbers))

    val myLottoResult = myLottos.getMyLottoResult(lottoJudgment)
    LottoResultView.printLottoResult(myLottoResult)
    LottoResultView.printLottoProfilt(myLottos.getProfit(myLottoResult))
}

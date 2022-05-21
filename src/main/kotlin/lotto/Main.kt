package lotto

import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val purchasePrice = LottoInputView.purchaseInputView()
    val myLottos = MyLottoTickets(LottoPurchase().buyLotto(purchasePrice))

    LottoResultView.printPurchasedLottoInfo(myLottos.lottoTickets)

    val lastLottoWinnerNumbers = LottoInputView.lastWinnerLotteryInputView()

    val lottoJudgment = LottoJudgment(LottoTicket(lastLottoWinnerNumbers))

    println("당첨통계")
    println("----------")
}

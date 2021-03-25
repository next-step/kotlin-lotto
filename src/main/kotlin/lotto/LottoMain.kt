package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val inputPayment = InputView.inputPayment()
    val lottoMachine = LottoMachine()
    val lottoPaper: LottoPaper = lottoMachine.issue(inputPayment)

    OutputView.showPurchases(lottoPaper)

    val winnerNumber = WinnerNumber(InputView.inputWinnerNumbers(), InputView.inputBonusNumber())
    val lottoRank: LottoRankPaper = lottoMachine.getLottoRank(winnerNumber, lottoPaper)

    OutputView.showResult(lottoRank)
}

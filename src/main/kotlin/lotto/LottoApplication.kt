package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount = InputView.getUserAmount()
    val lottoTickets = LottoController.purchaseLotto(amount)
    OutputView.printPurchaseResult(lottoTickets)
    val winningLotto = InputView.getUserWinningLotto()
    val lottoResults = LottoController.calculateLottoRank2(lottoTickets, winningLotto)
    // val lottoResults = LottoController.calculateLottoRank(lottoTickets, winningLotto)
    OutputView.printResults(lottoResults, amount)
}

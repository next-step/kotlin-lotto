package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoMatcher
import lotto.domain.LottoROIAnalysis
import lotto.model.LottoNumber
import lotto.model.WinningLotto

fun main() {
    val purchaseAmount = InputView.inputPurchaseAmount()
    val lotto = LottoMachine().draw(purchaseAmount)
    ResultView.printLotto(lotto)
    val winningLotto = issueWinningLotto()
    val lottoPrizeResults = LottoMatcher().match(winningLotto, lotto)
    ResultView.printLottoPrizeResults(lottoPrizeResults)
    ResultView.printLottoROIAnalysis(
        LottoROIAnalysis().returnOnInvestment(
            winningPrize = lottoPrizeResults.totalPrize(),
            purchaseAmount = purchaseAmount
        )
    )
}

private fun issueWinningLotto(): WinningLotto =
    InputView.inputWinningNumbers()
        .map(::LottoNumber).let(::WinningLotto)

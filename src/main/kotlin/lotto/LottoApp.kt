package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoRankResults
import lotto.domain.WinningLotto
import lotto.model.LottoNumber

fun main() {
    val purchaseAmount = InputView.inputPurchaseAmount()
    val lotto = LottoMachine().draw(purchaseAmount)
    ResultView.printLotto(lotto)
    val winningLotto = issueWinningLotto()
    val lottoPrizeResults = match(winningLotto, lotto)
    ResultView.printLottoPrizeResults(lottoPrizeResults)
    ResultView.printLottoROIAnalysis(lottoPrizeResults.returnOnInvestment(purchaseAmount))
}

private fun match(winningLotto: WinningLotto, userLotto: Lotto): LottoRankResults {
    return userLotto.matches(winningLotto)
}

private fun issueWinningLotto(): WinningLotto =
    InputView.inputWinningNumbers()
        .map(::LottoNumber).let(::WinningLotto)

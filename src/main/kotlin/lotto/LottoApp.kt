package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoRankResults
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.model.LottoNumber

fun main() {
    val purchaseAmount = InputView.inputPurchaseAmount()
    val manualLottoNumbers = InputView.issueManualLottoNumbers()
    val ticket = LottoTicket(purchaseAmount, manualLottoNumbers)
    ResultView.printLottoTicket(ticket)

    val lotto = LottoMachine().draw(ticket)
    ResultView.printLotto(lotto)
    val winningLotto = issueWinningLotto()

    val lottoPrizeResults = match(winningLotto, lotto)
    ResultView.printLottoPrizeResults(lottoPrizeResults)
    ResultView.printLottoROIAnalysis(lottoPrizeResults.returnOnInvestment(purchaseAmount))
}

private fun match(winningLotto: WinningLotto, userLotto: Lotto): LottoRankResults {
    return userLotto.matches(winningLotto)
}

private fun issueWinningLotto(): WinningLotto {
    val winningNumbers = InputView.inputWinningNumbers().map(::LottoNumber)
    val bonusNumber = LottoNumber(InputView.inputBonusNumber())
    return WinningLotto(winningNumbers, bonusNumber)
}

package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto

fun main() {
    val purchaseAmount = InputView.inputPurchaseAmount()
    val manualLottoNumbers = InputView.issueManualLottoNumbers()
    val ticket = LottoTicket(purchaseAmount, manualLottoNumbers)
    ResultView.printLottoTicket(ticket)

    val lotto = LottoMachine().draw(ticket)
    ResultView.printLotto(lotto)

    val winningNumbers = InputView.inputWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val lottoPrizeResults = lotto.matches(winningLotto)
    ResultView.printLottoPrizeResults(lottoPrizeResults)
    ResultView.printLottoROIAnalysis(lottoPrizeResults.returnOnInvestment(purchaseAmount))
}

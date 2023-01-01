package lotto

import lotto.domain.LottoMachine
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

    val lottoPrizeResults = lotto.matches(winningLotto)
    ResultView.printLottoPrizeResults(lottoPrizeResults)
    ResultView.printLottoROIAnalysis(lottoPrizeResults.returnOnInvestment(purchaseAmount))
}

private fun issueWinningLotto(): WinningLotto {
    val winningNumbers = InputView.inputWinningNumbers().map(::LottoNumber)
    val bonusNumber = LottoNumber(InputView.inputBonusNumber())
    return WinningLotto(winningNumbers, bonusNumber)
}

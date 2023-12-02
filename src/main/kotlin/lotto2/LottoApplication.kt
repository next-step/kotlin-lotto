package lotto2

import lotto2.domain.LottoNumber
import lotto2.domain.LottoNumbers
import lotto2.domain.LottoShop
import lotto2.domain.LottoTicket
import lotto2.domain.WinningLotto
import lotto2.ui.ConsoleView

fun main() {
    val lottoTickets = buyLottoTickets()
    val winningLotto = createWinningLotto()
    printLottoResultsAnalysis(winningLotto, lottoTickets)
}

private fun buyLottoTickets(): List<LottoTicket> {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = ConsoleView.Input.getPurchaseAmount()

    ConsoleView.Input.printManualTicketQuantityPrompt()
    val manualTicketQuantity = ConsoleView.Input.getManualTicketQuantity()
    ConsoleView.Input.printManualTicketNumbersPrompt()
    val manualTicketNumbers = ConsoleView.Input.getManualTicketNumbers(manualTicketQuantity)

    val manualTickets = LottoShop.buyManualTicket(purchaseAmount, manualTicketNumbers)
    val autoTickets = LottoShop.buyAutoTickets(purchaseAmount, purchaseAmount.toPurchasableTicketQuantity())

    val lottoTickets = manualTickets + autoTickets
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    return lottoTickets
}

private fun createWinningLotto(): WinningLotto {
    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = LottoNumbers(ConsoleView.Input.getLottoWinningNumbers())

    ConsoleView.Input.printBonusNumbersPrompt()
    val lastLottoBonusNumber = LottoNumber(ConsoleView.Input.getLottoBonusNumber())

    return WinningLotto(lastLottoWinningNumbers, lastLottoBonusNumber)
}

private fun printLottoResultsAnalysis(
    winningLotto: WinningLotto,
    lottoTickets: List<LottoTicket>
) {
    val rankings = winningLotto.getRankings(lottoTickets)
    ConsoleView.Output.printWinningStatistics(rankings.getWinningStatistics())
    ConsoleView.Output.printProfitRate(rankings.getProfitRate(lottoTickets.size * LottoShop.LOTTO_PRICE))
}

package lotto

fun main() {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = ConsoleView.Input.getPurchaseAmount()

    val lottoTickets = LottoTickets.buy(purchaseAmount)
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = ConsoleView.Input.getLottoWinningNumbers()
    val winningLotto = WinningLotto(lastLottoWinningNumbers)

    val lottoResultAnalytics = LottoResultAnalytics(winningLotto, lottoTickets)
    val winningStatistics = lottoResultAnalytics.calculateWinningStatistics()
    ConsoleView.Output.printWinningStatistics(winningStatistics)

    val profitRate = lottoResultAnalytics.calculateProfitRate()
    ConsoleView.Output.printProfitRate(profitRate)
}

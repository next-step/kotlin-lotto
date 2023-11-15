package lotto

fun main() {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = ConsoleView.Input.getPurchaseAmount()

    val lottoTickets = LottoTickets.buy(purchaseAmount)
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = ConsoleView.Input.getLottoWinningNumbers()
    val winningLotto = WinningLotto(lastLottoWinningNumbers)

    val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)
    val winningStatistics = lottoResultAnalytics.getWinningStatistics()
    ConsoleView.Output.printWinningStatistics(winningStatistics)

    val profitRate = lottoResultAnalytics.getProfitRate(lottoTickets.size())
    ConsoleView.Output.printProfitRate(profitRate)
}

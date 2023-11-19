package lotto

fun main() {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = ConsoleView.Input.getPurchaseAmount()

    val lottoTickets = LottoTickets.buy(purchaseAmount)
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = ConsoleView.Input.getLottoWinningNumbers()

    ConsoleView.Input.printBonusNumbersPrompt()
    val lastLottoBonusNumber = ConsoleView.Input.getLottoBonusNumber()

    val winningLotto = WinningLotto(lastLottoWinningNumbers, lastLottoBonusNumber)
    val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)
    val winningStatistics = lottoResultAnalytics.getWinningStatistics()
    ConsoleView.Output.printWinningStatistics(winningStatistics)

    val totalInvestment = lottoTickets.size() * LottoPolicy.LOTTO_PRICE
    val profitRate = lottoResultAnalytics.getProfitRate(totalInvestment)
    ConsoleView.Output.printProfitRate(profitRate)
}

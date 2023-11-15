package lotto

fun main() {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = createPurchaseAmount()

    val lottoTickets = LottoTickets.buy(purchaseAmount)
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = createLottoWinningNumbers()
    val winningLotto = WinningLotto(lastLottoWinningNumbers)

    val lottoResultAnalytics = LottoResultAnalytics(winningLotto, lottoTickets)
    val winningStatistics = lottoResultAnalytics.calculateWinningStatistics()
    ConsoleView.Output.printWinningStatistics(winningStatistics)

    val profitRate = lottoResultAnalytics.calculateProfitRate()
    ConsoleView.Output.printProfitRate(profitRate)
}

private fun createPurchaseAmount(): Int {
    val purchaseAmount = ConsoleView.Input.getUserInput().toIntOrNull()
        ?: throw IllegalArgumentException("구입 금액은 숫자로 입력해주세요. ")

    LottoPolicy.validatePurchaseAmount(purchaseAmount)

    return purchaseAmount
}

private fun createLottoWinningNumbers(): List<Int> {
    return ConsoleView.Input.getUserInput().split(",")
        .map { it.trim().toInt() }.sorted()
}

package lotto

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()

    val lottoMatching = LottoMatching()

    lottoMatching.purchase(purchaseMoney)

    ResultView.printTicketCount(lottoMatching.lottoTicketCount)

    ResultView.printTickets(lottoMatching.lottoTickets)

    val winningNumbers = InputView.getWinningNumbers()

    val bonusNumber = InputView.getBonusNumber()

    lottoMatching.checkResult(winningNumbers, bonusNumber)

    val statistics = Statistics().apply {
        this.run(lottoMatching.winningPrizes, purchaseMoney)
    }

    ResultView.printStatistics(statistics.statisticsRows)

    ResultView.printEarnings(statistics.earnings)
}

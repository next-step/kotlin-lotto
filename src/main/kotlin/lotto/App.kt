package lotto

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()

    val lottoMachine = LottoMachine()

    lottoMachine.purchase(purchaseMoney)

    ResultView.printTicketCount(lottoMachine.lottoTicketCount)

    ResultView.printTickets(lottoMachine.lottoTickets)

    val winningNumbers = InputView.getWinningNumbers()

    val bonusNumber = InputView.getBonusNumber()

    lottoMachine.checkResult(winningNumbers, bonusNumber)

    val statistics = Statistics().apply {
        this.run(lottoMachine.winningPrizes, purchaseMoney)
    }

    ResultView.printStatistics(statistics.statisticsRows)

    ResultView.printEarnings(statistics.earnings)
}

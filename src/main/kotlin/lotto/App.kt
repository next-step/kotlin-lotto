package lotto

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()

    val lottoMachine = LottoMachine()

    lottoMachine.purchase(purchaseMoney, Extractor.randomNumberFunc)

    ResultView.printTickets(lottoMachine.lottoTickets)

    val winningNumbers = InputView.getWinningNumbers()

    val bonusNumber = InputView.getBonusNumber()

    lottoMachine.checkResult(
        WinningLotto(winningNumbers, bonusNumber)
    )

    val statistics = Statistics().apply {
        this.run(lottoMachine.winningPrizes, purchaseMoney)
    }

    ResultView.printStatistics(statistics.statisticsRows)

    ResultView.printEarnings(statistics.earnings)
}

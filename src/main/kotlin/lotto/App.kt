package lotto

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()

    val lottoMachine = LottoMachine()

    val lottoTickets = lottoMachine.purchase(purchaseMoney, Extractor.randomNumberFunc)

    ResultView.printTickets(lottoTickets)

    val lottoWinning = LottoWinning(
        numbers = InputView.getWinningNumbers(),
        bonusNumber = InputView.getBonusNumber()
    )

    val lottoPrizes = lottoWinning.getPrizes(lottoTickets)

    ResultView.printResult(lottoPrizes.prizeResult, lottoPrizes.earnings(purchaseMoney))
}

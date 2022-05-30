package lotto

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()

    val lottoMachine = LottoMachine()

    val lottoTickets = lottoMachine.purchase(purchaseMoney, Extractor.randomNumberFunc)

    ResultView.printTickets(lottoTickets)

    val winningNumbers = InputView.getWinningNumbers()

    val bonusNumber = InputView.getBonusNumber()

    val lottoPrizes = LottoPrizes(
        lottoTickets.lottoTickets.map {
            LottoPrize.of(
                matchCount = it.matchCount(winningNumbers),
                matchBonus = it.isMatchBonus(bonusNumber),
            )
        }
    )

    ResultView.printResult(lottoPrizes.prizeResult, lottoPrizes.earnings(purchaseMoney))
}

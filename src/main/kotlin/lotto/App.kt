package lotto

import kotlin.math.floor

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()

    val lottoMachine = LottoMachine()

    val lottoTickets = lottoMachine.purchase(purchaseMoney, Extractor.randomNumberFunc)

    ResultView.printTickets(lottoTickets)

    val winningNumbers = InputView.getWinningNumbers()

    val bonusNumber = InputView.getBonusNumber()

    val winningPrizes = WinningPrizes(
        lottoTickets.lottery.map {
            val matchCount = winningNumbers.intersect(it.numbers.toSet()).size
            val matchBonus = matchCount == 5 && it.hasBonusNumber(bonusNumber)

            LottoPrize.of(
                matchCount = matchCount,
                matchBonus = matchBonus,
            )
        }
    )

    val earnings = winningPrizes.prizes.sumOf { it.price }.let {
        floor(it.toDouble() / purchaseMoney.money.toDouble() * 100) / 100
    }

    ResultView.printResult(winningPrizes.prizeResult, earnings)
}

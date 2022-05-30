package lotto

import kotlin.math.floor

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

    val earnings = lottoMachine.winningPrizes.prizes.sumOf { it.price }.let {
        floor(it.toDouble() / purchaseMoney.money.toDouble() * 100) / 100
    }

    ResultView.printResult(lottoMachine.winningPrizes.prizeResult, earnings)
}

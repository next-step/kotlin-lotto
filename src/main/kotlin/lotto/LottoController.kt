package lotto

import lotto.domain.AutoStrategy
import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.Lottoes
import lotto.domain.ManualStrategy
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.OutputView
import java.math.BigDecimal
import java.math.RoundingMode

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val money = Money(inputView.inputMoney())
    val numberOfManual = inputView.inputNumberOfManual()
    val lottoGame = LottoGame(money)

    val manualLottoes = inputManualLottoes(numberOfManual, lottoGame)
    val autoLottoes = lottoGame.purchaseLottoes(AutoStrategy())

    outputView.printPurchasedLottoes(manualLottoes, autoLottoes)
    val universalLottoes = Lottoes(manualLottoes.toList() + autoLottoes.toList())
    val winningLotto = WinningLotto(createWinningTicket(), createBonusNumber())

    val ranks = universalLottoes.getMyLottoesRanks(winningLotto)
    outputView.printLottoesResult(money, ranks)

    val rateOfReturn = calculateRateOfReturn(ranks.getWinningMoney(), money.spentMoney)
    outputView.printRateOfReturn(rateOfReturn)
}

private fun createWinningTicket(): LottoTicket {
    return LottoTicket(
        inputView.inputPrizeNumber().map {
            it.toInt()
        }
    )
}

private fun createBonusNumber(): LottoNumber {
    return LottoNumber.from(inputView.inputBonusNumber())
}

private fun inputManualLottoes(numberOfManual: Int, game: LottoGame): Lottoes {
    if (numberOfManual > 0) {
        val manualNumbers = inputView.inputManualNumbers(numberOfManual)
        return game.purchaseLottoes(ManualStrategy(manualNumbers))
    }
    return Lottoes(emptyList())
}

private fun calculateRateOfReturn(winningMoney: Long, spentMoney: Long): String {
    return BigDecimal(winningMoney)
        .divide(spentMoney.toBigDecimal(), 2, RoundingMode.FLOOR)
        .toString()
}

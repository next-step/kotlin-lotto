package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.Lottoes
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val money = Money(inputView.inputMoney())
    val numberOfManual = inputView.inputNumberOfManual()
    val lottoGame = LottoGame(money)

    val manualLottoes = inputManualLottoes(numberOfManual, lottoGame) ?: Lottoes(emptyList())
    val autoLottoes = lottoGame.purchaseAutoLottoes()

    outputView.printPurchasedLottoes(manualLottoes, autoLottoes)
    val universalLottoes = Lottoes(manualLottoes.toList() + autoLottoes.toList())
    val winningLotto = WinningLotto(createWinningTicket(), createBonusNumber())

    outputView.printLottoesResult(
        money,
        autoLottoes.getMyLottoesRanks(winningLotto),
        manualLottoes.getMyLottoesRanks(winningLotto)
    )
}

private fun createWinningTicket(): LottoTicket {
    return LottoTicket(
        inputView.inputPrizeNumber().map {
            LottoNumber.from(it.toInt())
        }
    )
}

private fun createBonusNumber(): LottoNumber {
    return LottoNumber.from(inputView.inputBonusNumber())
}

private fun inputManualLottoes(numberOfManual: Int, game: LottoGame): Lottoes? {
    if (numberOfManual > 0) {
        val manualNumbers = inputView.inputManualNumbers(numberOfManual)
        return game.purchaseManualLottoes(numberOfManual, manualNumbers)
    }
    return null
}

package lotto

import lotto.presentation.LottoGame
import lotto.usecase.LottoMachine
import lotto.usecase.LottoGenerator
import lotto.usecase.PurchaseAmountCalculator
import lotto.usecase.WinningsChecker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoGame = LottoGame(
        lottoMachine = LottoMachine(LottoGenerator()),
        winningsChecker = WinningsChecker(),
        calculator = PurchaseAmountCalculator(),
    )

    val purchaseAmount = inputView.inputPurchaseAmount()
    val lottos = lottoGame.buy(purchaseAmount)

    outputView.printLotto(lottos)

    val winningNumbers = inputView.inputWinningNumber()

    lottoGame
        .statistics(
            winningNumbers = winningNumbers,
            lottos = lottos,
        )
        .let { statistics ->
            outputView.printStatistics(statistics)
        }
}

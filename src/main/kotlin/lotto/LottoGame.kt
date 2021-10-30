package lotto

import lotto.`interface`.LottoGame
import lotto.usecase.LottoMachine
import lotto.usecase.LottoNumberGenerator
import lotto.usecase.RandomNumberGenerateStrategy
import lotto.usecase.WinningsChecker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoGame = LottoGame(
        lottoMachine = LottoMachine(
            LottoNumberGenerator(RandomNumberGenerateStrategy())
        ),
        winningsChecker = WinningsChecker(),
    )

    val purchaseAmount = inputView.inputPurchaseAmount()
    val lottos = lottoGame.buy(purchaseAmount)

    outputView.printLotto(lottos)

    val winningNumbers = inputView.inputWinningNumber()

    lottoGame
        .confirmWinning(
            winningNumbers = winningNumbers,
            lottos = lottos,
        )
        .let { statistics ->
            outputView.printStatistics(statistics)
        }
}

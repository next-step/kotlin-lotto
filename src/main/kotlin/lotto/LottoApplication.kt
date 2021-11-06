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
    val passivityCount = inputView.inputPassivityCount()
    val passivityLottoNumbers = inputView.inputPassivityLottoNumbers(passivityCount)

    val availablePurchaseCount = purchaseAmount / LottoMachine.LOTTO_PRICE

    val lottos = lottoGame.buy(
        availablePurchaseCount = availablePurchaseCount,
        passivityLottoNumbers = passivityLottoNumbers,
    )

    outputView.printLotto(lottos)

    val winningNumbers = inputView.inputWinningNumber()
    val bonusNumber = inputView.inputBonusNumber()

    lottoGame
        .statistics(
            winningNumbers = winningNumbers,
            lottos = lottos,
            bonusNumber = bonusNumber,
        )
        .let { statistics ->
            outputView.printStatistics(statistics)
        }
}

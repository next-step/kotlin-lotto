package lotto

import lotto.domain.model.LottoStatistics
import lotto.domain.model.Lottos
import lotto.presentation.LottoGame
import lotto.usecase.LottoMachine
import lotto.usecase.LottoGenerator
import lotto.usecase.PurchaseAmountCalculator
import lotto.usecase.WinningsChecker
import lotto.view.InputView
import lotto.view.OutputView

val inputView = InputView()
val outputView = OutputView()
val lottoGame = LottoGame(
    lottoMachine = LottoMachine(LottoGenerator()),
    winningsChecker = WinningsChecker(),
    calculator = PurchaseAmountCalculator(),
)

fun main() {
    val lottos = buyLottos()
    outputView.printLotto(lottos)

    getStatistics(lottos).let { statistics ->
        outputView.printStatistics(statistics)
    }
}

private fun buyLottos(): Lottos {
    val purchaseAmount = inputView.inputPurchaseAmount()
    val passivityCount = inputView.inputPassivityCount()
    val passivityLottoNumbers = inputView.inputPassivityLottoNumbers(passivityCount)

    val availablePurchaseCount = purchaseAmount / LottoMachine.LOTTO_PRICE

    return lottoGame.buy(
        availablePurchaseCount = availablePurchaseCount,
        passivityLottoNumbers = passivityLottoNumbers,
    )
}

private fun getStatistics(lottos: Lottos): LottoStatistics {
    val winningNumbers = inputView.inputWinningNumber()
    val bonusNumber = inputView.inputBonusNumber()

    return lottoGame.statistics(
        winningNumbers = winningNumbers,
        lottos = lottos,
        bonusNumber = bonusNumber,
    )
}

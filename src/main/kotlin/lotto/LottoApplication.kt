package lotto

import lotto.domain.model.LottoStatistics
import lotto.domain.model.Lottos
import lotto.presentation.LottoGame
import lotto.usecase.LottoMachine
import lotto.usecase.LottoGenerator
import lotto.usecase.PurchaseAmountCalculator
import lotto.usecase.WinningsChecker
import lotto.util.LottoNumberParser
import lotto.view.InputView
import lotto.view.OutputView

val lottoGame = LottoGame(
    lottoMachine = LottoMachine(LottoGenerator()),
    winningsChecker = WinningsChecker(),
    calculator = PurchaseAmountCalculator(),
)

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val purchaseAmount = inputView.inputPurchaseAmount()
    val passivityCount = inputView.inputPassivityCount()
    val passivityLottoNumbers = inputView.inputPassivityLottoNumbers(passivityCount)

    val lottos = buyLottos(
        purchaseAmount,
        passivityLottoNumbers.map { passivityLottoNumber ->
            LottoNumberParser.parse(passivityLottoNumber)
        }
    )
    outputView.printLotto(lottos)

    val winningNumbers = inputView.inputWinningNumber()
    val bonusNumber = inputView.inputBonusNumber()

    getStatistics(
        lottos,
        LottoNumberParser.parse(winningNumbers),
        bonusNumber
    ).let { statistics ->
        outputView.printStatistics(statistics)
    }
}

private fun buyLottos(
    purchaseAmount: Int,
    passivityLottoNumbers: List<List<Int>>,
): Lottos {
    val availablePurchaseCount = purchaseAmount / LottoMachine.LOTTO_PRICE

    return lottoGame.buy(
        availablePurchaseCount = availablePurchaseCount,
        passivityLottoNumbers = passivityLottoNumbers,
    )
}

private fun getStatistics(
    lottos: Lottos,
    winningNumbers: List<Int>,
    bonusNumber: Int,
): LottoStatistics {
    return lottoGame.statistics(
        winningNumbers = winningNumbers,
        lottos = lottos,
        bonusNumber = bonusNumber,
    )
}

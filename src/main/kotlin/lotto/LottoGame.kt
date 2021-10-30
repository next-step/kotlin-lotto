package lotto

import lotto.domain.WinningNumber
import lotto.usecase.LottoNumberGenerator
import lotto.usecase.LottoMachine
import lotto.usecase.WinningsChecker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoGame().start()
}

class LottoGame {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoMachine = LottoMachine(LottoNumberGenerator())
    private val winningsChecker = WinningsChecker()

    fun start() {
        val purchaseAmount = inputView.inputPurchaseAmount()

        val lottos = lottoMachine.buy(purchaseAmount)

        outputView.printLotto(lottos)

        val winningNumbers = inputView.inputWinningNumber()
        val winningNumber = WinningNumber(winningNumbers)

        val statistics = winningsChecker.check(
            lottos = lottos,
            winningNumber = winningNumber
        )

        outputView.printStatistics(statistics)
    }
}

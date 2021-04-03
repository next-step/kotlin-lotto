package lotto.ui

import lotto.domain.LottoNumberFactory
import lotto.domain.LottoStore
import lotto.domain.ManualCount
import lotto.domain.PurchaseAmount
import lotto.domain.result.WinningLotto
import lotto.domain.strategy.RANDOM_SHUFFLE
import view.InputView
import view.OutputView
import view.console.ConsoleInput
import view.console.ConsoleOutput

class LottoController private constructor(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        outputView.printPurchaseAmountMessage()
        val amount = PurchaseAmount(inputView.read())

        outputView.printManualLottoCountMessage()
        val manualCount = ManualCount(inputView.read())

        outputView.printInputManualLottoNumbersMessage()
        val manualTickets = LottoStore.purchaseManual(manualCount) { LottoNumberFactory.create(inputView.read()) }
        val autoTickets = LottoStore.purchaseAuto(amount, RANDOM_SHUFFLE)
        outputView.printLottoTickets(autoTickets, manualTickets)

        outputView.printInputWinningNumbersMessage()
        val winningNumbers = inputView.read()
        outputView.printInputBonusNumberMessage()
        val bonusNumber = inputView.read()

        val result = WinningLotto.of(LottoNumberFactory.create(winningNumbers), bonusNumber)
            .match(autoTickets)
        outputView.printLottoResult(result)
    }

    companion object {
        @Volatile
        private var instance: LottoController? = null

        @JvmStatic
        fun getInstance(consoleInput: ConsoleInput, consoleOutput: ConsoleOutput) =
            instance ?: synchronized(this) {
                instance ?: LottoController(consoleInput, consoleOutput).also { instance = it }
            }
    }
}

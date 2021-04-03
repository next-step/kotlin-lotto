package lotto.ui

import lotto.domain.LottoCount
import lotto.domain.LottoNumberFactory
import lotto.domain.LottoStore
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
        val purchaseAmount = PurchaseAmount(inputView.read())

        outputView.printManualLottoCountMessage()
        val manualCount = LottoCount(inputView.read())

        outputView.printInputManualLottoNumbersMessage()
        val tickets = LottoStore.purchase(purchaseAmount, manualCount, RANDOM_SHUFFLE) {
            LottoNumberFactory.create(inputView.read())
        }
        outputView.printLottoTickets(tickets, manualCount)

        outputView.printInputWinningNumbersMessage()
        val winningNumbers = inputView.read()
        outputView.printInputBonusNumberMessage()
        val bonusNumber = inputView.read()

        val result = WinningLotto.of(LottoNumberFactory.create(winningNumbers), bonusNumber)
            .match(tickets)
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

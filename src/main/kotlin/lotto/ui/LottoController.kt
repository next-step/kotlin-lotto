package lotto.ui

import lotto.domain.LottoStore
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
        val tickets = LottoStore().purchase(inputView.read())
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

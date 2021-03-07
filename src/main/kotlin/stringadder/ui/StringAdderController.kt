package stringadder.ui

import stringadder.domain.Parser
import view.InputView
import view.OutputView
import view.console.ConsoleInput
import view.console.ConsoleOutput

class StringAdderController private constructor(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        outputView.printStringAdderInputMessage()
        val result = Parser(inputView.read()).operands.sum()
        outputView.printStringAdderResultMessage(result)
    }

    companion object {
        @Volatile
        private var instance: StringAdderController? = null

        @JvmStatic
        fun getInstance(consoleInput: ConsoleInput, consoleOutput: ConsoleOutput) =
            instance ?: synchronized(this) {
                instance ?: StringAdderController(consoleInput, consoleOutput).also { instance = it }
            }
    }
}

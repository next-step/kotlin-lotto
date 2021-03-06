package stringadder.ui

import stringadder.domain.Parser
import view.console.ConsoleInput
import view.console.ConsoleOutput

class StringAdderController(private val consoleInput: ConsoleInput, private val consoleOutput: ConsoleOutput) {
    fun run() {
        consoleOutput.printStringAdderInputMessage()
        val operands = Parser(consoleInput.read()).operands
        consoleOutput.printStringAdderResultMessage(operands.sum())
    }
}

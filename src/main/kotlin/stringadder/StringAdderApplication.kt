package stringadder

import stringadder.ui.StringAdderController
import view.console.ConsoleInput
import view.console.ConsoleOutput

fun main() {
    StringAdderController.getInstance(ConsoleInput(), ConsoleOutput()).run()
}

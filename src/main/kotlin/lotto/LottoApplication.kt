package lotto

import lotto.ui.LottoController
import view.console.ConsoleInput
import view.console.ConsoleOutput

fun main() {
    LottoController.getInstance(ConsoleInput(), ConsoleOutput()).run()
}

package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInput
import lotto.view.ConsoleOutput

fun main() {
    val consoleInput = ConsoleInput()
    val consoleOutput = ConsoleOutput()
    val lottoController = LottoController(consoleInput, consoleOutput)

    lottoController.start()
}

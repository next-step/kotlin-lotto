package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInput
import lotto.view.ConsoleOutPut

fun main() {
    val consoleInput = ConsoleInput()
    val consoleOutPut = ConsoleOutPut()
    val lottoController = LottoController(consoleInput, consoleOutPut)

    lottoController.start()
}

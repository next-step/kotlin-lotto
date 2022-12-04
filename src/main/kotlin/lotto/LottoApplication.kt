package lotto

import lotto.`in`.ConsoleInput
import lotto.`in`.ConsoleOutPut
import lotto.`in`.LottoController

fun main() {
    val consoleInput = ConsoleInput()
    val consoleOutPut = ConsoleOutPut()
    val lottoController = LottoController(consoleInput, consoleOutPut)

    lottoController.start()
}

package lotto

import lotto.presentation.InputManager
import lotto.presentation.OutputManager

class LottoStore(
    private val inputManager: InputManager,
    private val outputManager: OutputManager
) {
    fun start() {
        val userPay = inputManager.inputPay()
        outputManager.printUserPay(userPay)
    }
}

fun main() {
    LottoStore(InputManager(), OutputManager()).start()
}

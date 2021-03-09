package lotto

import lotto.userInterface.Console

fun main() {
    val console = Console()
    val app = LottoApplication(console)
    app.run()
}

class LottoApplication(private val userInterface: Console) {

    fun run() {
        val amount = userInterface.inputPurchaseAmount()
    }
}

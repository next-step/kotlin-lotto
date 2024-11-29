package lotto

import lotto.view.InputView

fun main() {
    val lottoApplication = LottoApplication()
    lottoApplication.run()
}

class LottoApplication {
    fun run() {
        InputView.inputPurchaseAmount()
    }
}

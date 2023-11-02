package lotto

import lotto.ui.InputView

fun main() {
    val purchased = InputView().getPurchaseAmount()
    val lottoManager = LottoManager(purchased)

    println(lottoManager.purchased)
}

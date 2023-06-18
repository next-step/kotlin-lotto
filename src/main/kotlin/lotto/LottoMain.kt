package lotto

import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val totalPrice = inputView.getTotalPrice()
    val lottoSeller = LottoSeller()
    println(lottoSeller.sell(totalPrice))
}

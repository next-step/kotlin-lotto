package lotto

import lotto.view.InputView

fun main() {
    val inputView = InputView()

    val price = inputView.readPrice()
    print(price)
}

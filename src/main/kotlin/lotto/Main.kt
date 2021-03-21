package lotto

import lotto.domain.Lottos
import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val price = inputView.price()
    val lottos = Lottos.buyRandom(price)
    inputView.printBoughtResult(lottos)
}

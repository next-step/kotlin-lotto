package lotto

import lotto.domain.Price
import lotto.view.InputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).checkLottoCount()
    InputView.printBoughtLotto(lottoCount)
}

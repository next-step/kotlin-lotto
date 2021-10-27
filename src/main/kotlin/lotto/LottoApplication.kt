package lotto

import lotto.model.Price
import lotto.view.InputView
import lotto.view.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val price = inputView.inputLottoPrice()
    val lottoCount = Price(price).lottoCount
    outputView.resultLottoCount(lottoCount)
}

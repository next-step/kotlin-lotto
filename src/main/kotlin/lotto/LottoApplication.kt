package lotto

import lotto.model.GenerateLotto
import lotto.model.Price
import lotto.view.InputView
import lotto.view.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val price = inputView.inputLottoPrice()
    val lottoPrice = Price(price)
    outputView.resultLottoCount(lottoPrice.lottoCount)

    GenerateLotto(lottoPrice).generateLottoList().run {
        outputView.printNumber(this)
    }
}

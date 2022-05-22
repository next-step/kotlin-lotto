package lotto

import lotto.domain.LottoPrice
import lotto.view.InputView

fun main() {
    val inputView = InputView()

    val price = inputView.readPrice()
    val lottoPrice = LottoPrice(price)

    print(lottoPrice)
}

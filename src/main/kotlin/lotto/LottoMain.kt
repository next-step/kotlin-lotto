package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPrice = InputView.getTotalPrice()
    val lottoSeller = LottoSeller(LottoFactory)
    ResultView.printNumOfLottos(lottoSeller.sell(totalPrice))
}

package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPrice = InputView.getTotalPrice()
    val lottoSeller = LottoSeller(LottoFactory)
    ResultView.printPurchasedLottos(lottoSeller.sell(totalPrice))
    val winNumbers = InputView.getPrevWeekWinningNumbers()
    print(winNumbers)
}

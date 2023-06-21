package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPrice = InputView.getTotalPrice()
    val lottoSeller = LottoSeller(LottoFactory, 1000)
    val lottos = lottoSeller.sell(totalPrice)
    ResultView.printPurchasedLottos(lottos)
    val winNumbers = InputView.getPrevWeekWinningNumbers()
    val drawResult = LottoDrawingMachine.draw(winNumbers, lottos)
    ResultView.printDrawResult(drawResult)
}

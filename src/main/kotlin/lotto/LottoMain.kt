package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPrice = InputView.getTotalPrice()
    val lottoSeller = LottoSeller(LottoFactory, 1000)
    val lottos = lottoSeller.sell(totalPrice)
    ResultView.printPurchasedLottos(lottos)
    val winNumbers = LottoNumber.of(InputView.getPrevWeekWinningNumbers())
    val bonusNumber = LottoNumber.of(InputView.getBonusNumber())
    val drawResult = LottoDrawingMachine.draw(WinningLotto(winNumbers, listOf(bonusNumber)), lottos)
    ResultView.printDrawResult(drawResult)
}

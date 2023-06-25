package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPrice = InputView.getTotalPrice()
    val lottoSeller = LottoSeller(AutoLottoFactory, 1000)
    val manualLottoCount = InputView.getManualLottoCount()
    val manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoCount)
    val lottos = lottoSeller.sell(LottoPurchaseOrder(totalPrice, manualLottoNumbers.map { LottoNumber.of(it) }))
    ResultView.printPurchasedLottos(lottos)
    val winNumbers = LottoNumber.of(InputView.getPrevWeekWinningNumbers())
    val bonusNumber = LottoNumber.of(InputView.getBonusNumber())
    val drawResult = LottoDrawingMachine.draw(WinningLotto(winNumbers, listOf(bonusNumber)), lottos)
    ResultView.printDrawResult(drawResult)
}

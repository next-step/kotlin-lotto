package lotto

import lotto.application.LottoMachine
import lotto.application.vo.Purchase
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val purchase = Purchase(InputView.inputAmount(), InputView.inputManualLottoCount())
    val manualLottoNumbers = InputView.inputManualLottoNumbers(purchase.purchaseCounts.manualLottoCount.count)
    ResultView.printLottoCount(purchase)

    val lottoMachine = LottoMachine(purchase)
    val lottoBundle = lottoMachine.buy(manualLottoNumbers)
    ResultView.printLottoBundle(lottoBundle)

    val winningLotto = WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber())
    val lottoResult = lottoMachine.drawLottoBundle(lottoBundle, winningLotto)
    ResultView.printWinningResult(lottoResult)
}

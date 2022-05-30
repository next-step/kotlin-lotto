package lotto

import lotto.application.LottoMachine
import lotto.application.PurchaseFactory
import lotto.domain.LottoBundle
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val purchase = PurchaseFactory.create(InputView.inputAmount(), InputView.inputManualLottoCount())
    val manualLottoNumbers = InputView.inputManualLottoNumbers(purchase.purchaseCounts.manualLottoCount.count)
    ResultView.printLottoCount(purchase)

    val lottoMachine = LottoMachine(purchase)
    val lottoBundle = buildList {
        addAll(lottoMachine.buyManual(manualLottoNumbers))
        addAll(lottoMachine.buyAuto())
    }.let(::LottoBundle)
    ResultView.printLottoBundle(lottoBundle)

    val winningLotto = WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber())
    val lottoResult = lottoMachine.drawLottoBundle(lottoBundle, winningLotto)
    ResultView.printWinningResult(lottoResult)
}

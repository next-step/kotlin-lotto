package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputMoney = InputView.enterMoney()
    val manualLottoCount = InputView.enterManualLottoCount()
    val lottoCount = LottoOrder(inputMoney, manualLottoCount)
    val lottoList = LottoFactory.buyLotto(lottoCount.autoLottoCount, InputView.enterManualLotto(manualLottoCount))
    OutputView.buyLotto(lottoList, lottoCount)
    val winningLotto = WinningLotto(Lotto(InputView.enterWinningLotto()), InputView.enterBonusNumber())
    OutputView.printLottoResult(LottoResult(lottoList, winningLotto))
}

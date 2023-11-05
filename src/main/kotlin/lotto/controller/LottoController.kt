package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.LottoStore
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    fun run() {
        val inputPrice = InputView.inputPrice()
        val manualLottoCount = InputView.inputManualLottoCount()
        val manualLottos = InputView.inputManualLotto(manualLottoCount)
        val lottos = LottoStore.buyLottos(inputPrice.price, manualLottos)
        OutputView.printLotto(lottos)

        val winningLottoNumber = LottoNumbers(InputView.inputWinningLotto())
        val bonusBall = InputView.inputBonusBall()
        val winningLotto = WinningLotto(winningLottoNumber, bonusBall)
        val winningRanks = lottos.matchLotto(winningLotto)

        OutputView.printWinningResult(winningRanks)
        OutputView.printRateOfReturn(inputPrice.price, winningRanks)
    }
}

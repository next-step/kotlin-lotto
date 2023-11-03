package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    fun run() {
        val inputPrice = InputView.inputPrice()
        val lottos = LottoStore.buyLottos(inputPrice)
        OutputView.printLotto(lottos)

        val winningLotto = Lotto(InputView.inputWinningLotto())
        val winningRanks = lottos.matchLotto(winningLotto)

        OutputView.printWinningResult(winningRanks)
        OutputView.printRateOfReturn(inputPrice, winningRanks)
    }
}

package lotto.controller

import lotto.domain.LottoNumberAutoGenerator
import lotto.domain.LottoNumbers
import lotto.domain.LottoStore
import lotto.domain.LottoStore.Companion.LOTTO_POOL
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    fun run() {
        val inputPrice = InputView.inputPrice()
        val manualLottoCount = InputView.inputManualLottoCount()
        val manualLottos = InputView.inputManualLotto(manualLottoCount)
        val lottoStore = LottoStore(LottoNumberAutoGenerator { LOTTO_POOL.shuffled() })
        val lottos = lottoStore.buyLottos(inputPrice.price, manualLottos)
        OutputView.printLotto(lottos)

        val winningLottoNumber = LottoNumbers(InputView.inputWinningLotto())
        val bonusBall = InputView.inputBonusBall()
        val winningLotto = WinningLotto(winningLottoNumber, bonusBall)
        val winningRanks = lottos.matchLotto(winningLotto)

        OutputView.printWinningResult(winningRanks.winningRankGroupBy())
        OutputView.printRateOfReturn(inputPrice.price, winningRanks)
    }
}

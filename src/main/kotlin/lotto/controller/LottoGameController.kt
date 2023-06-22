package lotto.controller

import lotto.domain.LottoShop
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoGameController {
    fun play() {
        val money = LottoInputView.inputMoney()
        val manualLottos = LottoInputView.inputManualLottos()
        val lottos = LottoShop.sellByMoneyWithManualLottos(money, manualLottos)
        LottoOutputView.printLottos(lottos)

        val winningLotto = LottoInputView.inputWinningLotto()
        val lottosResult = lottos.calculateResults(winningLotto)
        LottoOutputView.printLottoResults(lottosResult)
    }
}

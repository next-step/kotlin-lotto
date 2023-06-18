package lotto.controller

import lotto.domain.LottoShop
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoGameController {
    fun play() {
        val money = LottoInputView.inputMoney()
        val lottos = LottoShop.sellByMoney(money)
        LottoOutputView.printLottos(lottos)

        val winningNumbers = LottoInputView.inputWinningLottoNumbers()
        val lottosResult = lottos.calculateResults(winningNumbers)
        LottoOutputView.printLottoResults(lottosResult)
    }
}

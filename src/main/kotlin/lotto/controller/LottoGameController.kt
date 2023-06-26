package lotto.controller

import lotto.domain.LottoShop
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoGameController {
    fun play() {
        val lottosGenerateRequest = LottoInputView.inputLottoGenerateRequest()
        val lottosGenerateResponse = LottoShop.sellByMoneyWithManualLottos(lottosGenerateRequest)
        LottoOutputView.printLottos(lottosGenerateResponse)

        val lottos = lottosGenerateResponse.lottos
        val winningLotto = LottoInputView.inputWinningLotto()
        val lottosResult = lottos.calculateResults(winningLotto)
        LottoOutputView.printLottoResults(lottosResult)
    }
}

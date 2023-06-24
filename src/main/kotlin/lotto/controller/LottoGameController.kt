package lotto.controller

import lotto.domain.LottoShop
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoGameController {
    fun play() {
        val money = LottoInputView.inputMoney()
        val manualLottosRequest = LottoInputView.inputManualLottoView()
        val generatedLottosResponse = LottoShop.sellByMoneyWithManualLottos(money, manualLottosRequest.lottoNumbers)
        LottoOutputView.printLottos(generatedLottosResponse)

        val lottos = generatedLottosResponse.lottos
        val winningLotto = LottoInputView.inputWinningLotto()
        val lottosResult = lottos.calculateResults(winningLotto)
        LottoOutputView.printLottoResults(lottosResult)
    }
}

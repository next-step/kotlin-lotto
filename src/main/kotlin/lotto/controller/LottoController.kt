package lotto.controller

import lotto.domain.AutoLottoCreateMachine
import lotto.domain.LottoRateOfReturnCalculator
import lotto.domain.WinningType
import lotto.view.InputView
import lotto.view.ResultView

object LottoController {

    /**
     * 로또 기계 시작
     * */
    fun runLottoMachine() {
        val buyPrice = InputView.drawBuyPrice()

        val selfLottos = InputView.getSelfLottoNumbers()
        val autoLottos = AutoLottoCreateMachine.buyAutoLottoList(selfLottos.size, buyPrice)

        InputView.drawLottoList(selfLottos, autoLottos)

        val winningNumbers = InputView.drawWinningLottoNumbers()
        val winningBonusNumber = InputView.drawWinningBonusNumber()
        val lottoResultList = WinningType.runDrawLottos(winningNumbers, winningBonusNumber, selfLottos + autoLottos)

        ResultView.drawLottoMatchResultList(lottoResultList)

        val rateOfReturn = LottoRateOfReturnCalculator.rateOfReturn(buyPrice, lottoResultList)
        ResultView.drawLottoMatchResultRateOfReturn(rateOfReturn)
    }
}

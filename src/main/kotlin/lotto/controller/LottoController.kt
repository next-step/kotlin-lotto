package lotto.controller

import lotto.domain.LottoCreateMachine
import lotto.domain.WinningType
import lotto.domain.LottoRateOfReturnCalculator
import lotto.view.InputView
import lotto.view.ResultView

object LottoController {

    /**
     * 로또 기계 시작
     * */
    fun runLottoMachine() {
        val buyPrice = InputView.drawBuyPrice()
        val lottoList = LottoCreateMachine.buyLottoList(buyPrice)

        InputView.drawLottoList(lottoList)

        val winningNumbers = InputView.drawWinningLottoNumber()
        val winningBonusNumber = InputView.drawWinningBonusNumber()
        val lottoResultList = WinningType.runDrawLottos(winningNumbers, winningBonusNumber, lottoList)

        ResultView.drawLottoMatchResultList(lottoResultList)

        val rateOfReturn = LottoRateOfReturnCalculator.rateOfReturn(buyPrice, lottoResultList)
        ResultView.drawLottoMatchResultRateOfReturn(rateOfReturn)
    }
}

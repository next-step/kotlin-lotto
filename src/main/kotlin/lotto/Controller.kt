package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.StringNumbers
import lotto.domain.WinningLotto
import lotto.domain.WinningResult
import lotto.domain.WinningStatistics
import lotto.ui.InputView
import lotto.ui.ResultView

class Controller(private val inputView: InputView, private val resultView: ResultView) {
    fun startLotto() {
        val lottoMachine = getLottoMachine()
        val lottoList = publishLotto(lottoMachine)
        val winningLotto = publishWinningLotto()
        resultLotto(lottoList, winningLotto, lottoMachine.price)
    }

    private fun getLottoMachine(): LottoMachine {
        val price = inputView.inputPurchasePrice()
        return LottoMachine(price)
    }

    private fun publishLotto(lottoMachine: LottoMachine): List<Lotto> {
        val lottoList = lottoMachine.publishLotto()
        resultView.printPurchaseCount(lottoMachine.purchaseCount)
        resultView.printPurchaseLotteNumbers(lottoList)
        return lottoList
    }

    private fun publishWinningLotto(): WinningLotto {
        val winningNumbersString = inputView.inputLastWeekNumbers()
        val bonusNumber = LottoNumber(inputView.inputBonusNumber())
        return WinningLotto(StringNumbers(winningNumbersString.split(",")), bonusNumber)
    }

    private fun resultLotto(lottoList: List<Lotto>, winningLotto: WinningLotto, price: Int) {
        val winningResult = WinningResult(lottoList, winningLotto)
        val winningStatistics = WinningStatistics(price)

        resultView.printWinningStatisticsStart()
        resultView.printWinningStatistics(winningResult)
        resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn(winningResult.getWinningPrice()))
    }
}

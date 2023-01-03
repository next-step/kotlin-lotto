package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.ManualLottoInfo
import lotto.domain.PublishLotto
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
        val manualCount = inputView.inputManualCount()
        val manualLottoInfo = ManualLottoInfo(manualCount, inputView.inputManualLotto(manualCount))
        return LottoMachine(price, manualLottoInfo)
    }

    private fun publishLotto(lottoMachine: LottoMachine): PublishLotto {
        val publishLotto = lottoMachine.publishLotto()
        resultView.printPurchaseCount(publishLotto.manualLottos.size, publishLotto.autoLottos.size)
        resultView.printPurchaseLotteNumbers(publishLotto.getAllLotto())
        return publishLotto
    }

    private fun publishWinningLotto(): WinningLotto {
        val winningNumbersString = inputView.inputLastWeekNumbers()
        val bonusNumber = LottoNumber(inputView.inputBonusNumber())
        return WinningLotto(StringNumbers(winningNumbersString), bonusNumber)
    }

    private fun resultLotto(publishLotto: PublishLotto, winningLotto: WinningLotto, price: Int) {
        val winningResult = WinningResult(publishLotto.getAllLotto(), winningLotto)
        val winningStatistics = WinningStatistics(price)

        resultView.printWinningStatisticsStart()
        resultView.printWinningStatistics(winningResult)
        resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn(winningResult.getWinningPrice()))
    }
}

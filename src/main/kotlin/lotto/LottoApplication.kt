package lotto

import lotto.dto.LottoBundle
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication(
    private val rateCalculator: RateCalculator,
    private val lottoChecker: LottoChecker,
) {

    private val inputView = InputView
    private val resultView = ResultView

    fun lottoRun() {
        val lottoBundle = getLottoBundleByMoney()

        val lastWeekNumber = inputView.printInputLottoNumberByLastWeek()
        resultView.printEnter()

        resultView.printResult()
        val collectCounts = lottoChecker.lottoCheck(lastWeekNumber, lottoBundle.lottoBundle)

        val resultGroup = lottoChecker.lottoResultGroup(collectCounts)
        resultView.printWinningResult(resultGroup)

        val winningMoney = lottoChecker.winningMoneyCheck(collectCounts)

        val returnRatio = rateCalculator.calculateRateOfReturn(lottoBundle.inputMoney, winningMoney)
        resultView.printRateOfReturn(returnRatio)
    }

    private fun getLottoBundleByMoney(): LottoBundle {
        val inputMoney = inputView.printInputLottoBuyMoney().toInt()
        resultView.printLottoCount(inputMoney)

        val lottoManager = LottoManager()

        val lottoBundle = lottoManager.buyLotto(inputMoney)
        resultView.printLottoBundle(lottoBundle)
        resultView.printEnter()
        return LottoBundle(inputMoney, lottoBundle)
    }
}

fun main() {
    LottoApplication(RateCalculator(), LottoChecker()).lottoRun()
}

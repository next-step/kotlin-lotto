package lotto

import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication(
    private val calculator: Calculator,
    private val lotto: Lotto,
    private val lottoChecker: LottoChecker,
) {

    private val inputView = InputView
    private val resultView = ResultView

    fun lottoRun() {
        val (inputMoney, lottoBundle) = getLottoBundleByMoney()

        val lastWeekNumber = inputView.printInputLottoNumberByLastWeek()
        resultView.printEnter()

        resultView.printResult()
        val collectCounts = lottoChecker.lottoCheck(lastWeekNumber, lottoBundle)

        val resultGroup = lottoChecker.lottoResultGroup(collectCounts)
        resultView.printWinningResult(resultGroup)

        val winningMoney = lottoChecker.winningMoneyCheck(collectCounts)

        val returnRatio = calculator.calculateRateOfReturn(inputMoney, winningMoney)
        resultView.printRateOfReturn(returnRatio)
    }

    private fun getLottoBundleByMoney(): Pair<Int, List<List<Int>>> {
        val inputMoney = inputView.printInputLottoBuyMoney().toInt()
        resultView.printLottoCount(inputMoney)

        val lottoBundle = lotto.buyLotto(inputMoney)
        resultView.printLottoBundle(lottoBundle)
        resultView.printEnter()
        return Pair(inputMoney, lottoBundle)
    }
}

fun main() {
    LottoApplication(Calculator(),Lotto(),LottoChecker()).lottoRun()
}

package lotto

import lotto.domain.LottoMachine
import lotto.domain.ManualLottoDispenser
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun run() {
        val money = inputView.inputMoney()
        val manualLotto = inputView.inputManualLotto()
        val lottoDispenser = ManualLottoDispenser(manualLottos = manualLotto.toTypedArray())

        val lottoMachine = LottoMachine(money, lottoDispenser)
        resultView.printLottos(lottoMachine.issuedLottos)

        val winningLotto = inputView.inputWinningLotto()
        val statistics = lottoMachine.issueStatistics(winningLotto)
        resultView.printStatistic(statistics)
    }

}

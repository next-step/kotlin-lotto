package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMachine
import lotto.domain.ManualLottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun run() {
        val money = inputView.inputMoney()
        val manualLotto = inputView.inputManualLotto()
        val lottoGenerator = manualLottoGenerator(*manualLotto.toTypedArray())

        val lottoMachine = LottoMachine(lottoGenerator)
        val issueLottos = lottoMachine.issueLottos(money)
        resultView.printLottos(issueLottos)

        val winningLotto = inputView.inputWinningLotto()
        val statistics = lottoMachine.issueStatistics(winningLotto)
        resultView.printStatistic(statistics)
    }

    private fun manualLottoGenerator(vararg manualLottos: Lotto): LottoGenerator {
        return ManualLottoGenerator(randomLottoGenerator(), *manualLottos)
    }

    private fun randomLottoGenerator(): LottoGenerator {
        return LottoGenerator { Lotto.random() }
    }
}

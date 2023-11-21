package lotto

import lotto.domain.LOTTO_PRICE
import lotto.domain.Lotto
import lotto.domain.LottoDispenser
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
        val lottoGenerator = manualLottoGenerator(*manualLotto.toTypedArray())

        val lottoMachine = LottoMachine(lottoGenerator, money)
        val issueLottos = lottoMachine.issuedLottos
        resultView.printLottos(issueLottos)

        val winningLotto = inputView.inputWinningLotto()
        val statistics = lottoMachine.issueStatistics(winningLotto)
        resultView.printStatistic(statistics)
    }

    private fun manualLottoGenerator(vararg manualLottos: Lotto): LottoDispenser {
        return ManualLottoDispenser(randomLottoGenerator(), *manualLottos)
    }

    private fun randomLottoGenerator(): LottoDispenser {
        return LottoDispenser { money ->
            val issuedLottoSize = money / LOTTO_PRICE
            (0 until issuedLottoSize)
                .map { Lotto.random() }
                .toList()
        }
    }
}

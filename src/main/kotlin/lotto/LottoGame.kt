package lotto

import lotto.domain.Lotto
import lotto.domain.LottoChecker
import lotto.domain.LottoGenerator
import lotto.io.InputView
import lotto.io.ResultView

object LottoGame {

    fun start() {
        val lottos = getLottos()
        ResultView.printLottos(lottos)
        val winNumber = InputView.getWinNumbers()
        printResult(winNumber, lottos)
    }

    private fun getLottos(): List<Lotto> {
        val amount = InputView.getAmount()
        return LottoGenerator.generateLottos(amount)
    }

    private fun printResult(winNumber: List<Int>, lottos: List<Lotto>) {
        val result = LottoChecker.checkResult(lottos, winNumber)
        ResultView.printResult(result, lottos.size * Lotto.LOTTO_PRICE)
    }
}

package lotto

import lotto.domain.LottoChecker
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinNumbers
import lotto.io.InputView
import lotto.io.ResultView

object LottoGame {

    fun start() {
        val lottos = getLottos()
        ResultView.printLottos(lottos)
        val winNumber = getWinNumbers()
        printResult(winNumber, lottos)
    }

    private fun getWinNumbers(): WinNumbers {
        val winNumbers = InputView.getWinNumbers()
        return WinNumbers(winNumbers.map { LottoNumber(it) })
    }

    private fun getLottos(): Lottos {
        val amount = InputView.getAmount()
        return LottoGenerator.generateLottos(amount)
    }

    private fun printResult(winNumbers: WinNumbers, lottos: Lottos) {
        val result = LottoChecker.checkResult(lottos, winNumbers)
        ResultView.printResult(result)
    }
}

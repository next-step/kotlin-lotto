package lotto

import lotto.domain.LottoChecker
import lotto.domain.LottoSeller
import lotto.domain.Lottos
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinNumbers
import lotto.io.InputView
import lotto.io.ResultView

object LottoGame {

    fun start() {
        val lottos = getLottos()
        ResultView.printLottos(lottos)
        val winNumbers = getWinNumbers()
        printResult(winNumbers, lottos)
    }

    private fun getWinNumbers(): WinNumbers {
        val winNumber = InputView.getWinNumbers()
        val bonusNumber = InputView.getBonusNumber()
        return WinNumbers(winNumber, bonusNumber)
    }

    private fun getLottos(): Lottos {
        val amount = InputView.getAmount()
        return LottoSeller(RandomLottoGenerator).sellLottos(amount)
    }

    private fun printResult(winNumbers: WinNumbers, lottos: Lottos) {
        val result = LottoChecker.checkResult(lottos, winNumbers)
        ResultView.printResult(result)
    }
}

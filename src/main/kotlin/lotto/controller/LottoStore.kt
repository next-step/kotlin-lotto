package lotto.controller

import lotto.domain.LottoChecker
import lotto.domain.LottoMachine
import lotto.ui.InputView.getNumbers
import lotto.ui.InputView.getWinningNumbers
import lotto.ui.ResultView.show
import lotto.ui.UserInterface.showNumbers

class LottoStore {
    private val lottoMachine: LottoMachine = LottoMachine()
    private val lottoChecker: LottoChecker = LottoChecker()
    fun lotto() {
        val money = getNumbers()
        val lottos = lottoMachine.purchase(money)
        showNumbers(lottos)

        val winningNumbers = getWinningNumbers()

        val winNumStatistics = lottoChecker.getWinNumStatistics(lottos, winningNumbers)
        show(winNumStatistics)
    }
}

fun main() {
    LottoStore().lotto()
}

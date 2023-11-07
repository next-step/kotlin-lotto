package lotto.controller

import lotto.domain.LottoChecker
import lotto.domain.LottoMachine
import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.ui.UserInterface

class LottoStore {
    private val inputView: InputView = InputView()
    private val userInterface: UserInterface = UserInterface()
    private val resultView: ResultView = ResultView()
    private val lottoMachine: LottoMachine = LottoMachine()
    private val lottoChecker: LottoChecker = LottoChecker()
    fun lotto() {
        val money = inputView.getNumbers()
        val lottos = lottoMachine.purchase(money)
        userInterface.showNumbers(lottos)

        val winningNumbers = inputView.getWinningNumbers()

        val winNumStatistics = lottoChecker.getWinNumStatistics(lottos, winningNumbers)
        println("inputView = $winNumStatistics")
        resultView.show(winNumStatistics)
    }
}

fun main() {
    LottoStore().lotto()
}

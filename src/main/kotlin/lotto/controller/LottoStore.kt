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
    private val lottoMachine: LottoMachine = LottoMachine(1000)
    private val lottoChecker: LottoChecker = LottoChecker()

    private val lotteryAmount: Map<Int, Int> = mapOf(
        3 to 5000,
        4 to 50000,
        5 to 15000000,
        6 to 2000000000,
    )
    fun lotto() {
        val money = inputView.getNumbers()
        val lottos = lottoMachine.purchase(money)
        userInterface.showNumbers(lottos)

        val winningNumbers = inputView.getWinningNumbers()

        val winNumStatistics = lottoChecker.getWinNumStatistics(lottos, winningNumbers)
        println("inputView = $winNumStatistics")
        resultView.show(winNumStatistics, lotteryAmount)
    }
}

fun main() {
    LottoStore().lotto()
}

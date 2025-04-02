package lotto

import lotto.machine.AutoMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {
    fun run() {
        val winningStatistics = WinningStatistics()
        val amount = inputView.getPurchaseAmount()
        val ticketCount = (amount / TICKET_COST).toInt()
        val winningLotto = WinningLotto(Lotto(inputView.getWinningNumbers().map { LottoNumber(it) }))

        val lottos = AutoMachine().generate(ticketCount)
        resultView.printLottos(lottos)

        lottos.forEach {
            val matchCount = winningLotto.matchCount(it)
            val rank = Rank.valueOf(matchCount)
            winningStatistics.addRank(rank)
        }

        resultView.printWinningStatistics(winningStatistics)
        resultView.printProfit(winningStatistics.calculateProfit(amount))
    }

    companion object {
        private const val TICKET_COST = 1000
    }
}

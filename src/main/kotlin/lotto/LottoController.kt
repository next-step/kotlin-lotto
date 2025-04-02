package lotto

import lotto.machine.AutoMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {
    fun run() {
        val amount = inputView.getPurchaseAmount()
        val ticketCount = (amount / TICKET_COST).toInt()
        val winningLotto = inputView.getWinningNumbers()

        val lottos = AutoMachine().generate(ticketCount)
        resultView.printLottos(lottos)

        val winningStatistics = getWinningStatistics(lottos, winningLotto)

        resultView.printWinningStatistics(winningStatistics)
        resultView.printProfit(winningStatistics.calculateProfit(amount))
    }

    private fun getWinningStatistics(
        lottos: List<Lotto>,
        winningLotto: WinningLotto,
    ): WinningStatistics {
        val rankCount = Rank.entries.associateWith { DEFAULT }.toMutableMap()
        lottos.forEach {
            val matchCount = winningLotto.matchCount(it)
            val rank = Rank.valueOf(matchCount)
            rankCount[rank] = rankCount[rank]?.plus(PLUS) ?: PLUS
        }
        return WinningStatistics(rankCount)
    }

    companion object {
        private const val TICKET_COST = 1000
        private const val DEFAULT = 0
        private const val PLUS = 1
    }
}

package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoStatistics
import lotto.domain.Winning
import lotto.domain.WinningMatcher
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView().getMoney()
    val tickets = LottoMachine().buy(money)
    ResultView().printTickets(tickets)

    val winner = InputView().getPastWinner()

    val lottoResults = mutableMapOf<Winning, Int>()

    tickets.forEach { lotto ->
        val winning = WinningMatcher(winner).getPlace(lotto)
        lottoResults[winning] = lottoResults.getOrDefault(winning, 0) + 1
    }

    ResultView().printLottoResult(lottoResults)

    val statistics = LottoStatistics(money, lottoResults)
    ResultView().printWinningStatistics(statistics)
}

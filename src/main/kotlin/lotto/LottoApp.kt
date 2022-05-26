package lotto

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

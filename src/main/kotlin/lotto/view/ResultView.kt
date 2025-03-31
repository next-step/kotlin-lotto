package lotto.view

import lotto.model.LottoResult
import lotto.model.TicketModel

class ResultView {

    companion object {
        fun showTickets(tickets: List<TicketModel>) {
            println("You have purchased ${tickets.size} tickets.")
            tickets.forEach { println(it) }
        }

        fun showStatistics(result: LottoResult, purchaseAmount: Int) {
            println("Winning Statistics")
            println("------------------")

            val stats = result.calculateResult()
            val prizeMap = mapOf(
                3 to 5_000L,
                4 to 50_000L,
                5 to 1_500_000L,
                6 to 2_000_000_000L
            )

            prizeMap.forEach { (matchCount, prize) ->
                val count = stats.getOrDefault(matchCount, 0)
                println("$matchCount Matches ($prize KRW) - $count tickets")
            }

            val returnRate = result.returnRate(purchaseAmount)
            println("Total return rate is %.2f (A rate below 1 means a loss)".format(returnRate))
        }
    }

}
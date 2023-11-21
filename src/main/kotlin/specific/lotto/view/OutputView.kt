package specific.lotto.view

import specific.lotto.domain.Rank
import specific.lotto.domain.Tickets
import specific.lotto.domain.WinningResult

object OutputView {
    fun printTickets(tickets: Tickets) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.numbers.sortedBy { number -> number.value })
        }
    }

    fun printWinningResult(winningResult: WinningResult) {
        println("당첨 통계")
        println("---------")
        Rank.values()
            .filter { it != Rank.NO_WIN }
            .forEach {
                println("${it.condition} (${it.prize}원- ${winningResult.aggregatedData[Rank.NO_WIN]}개)")
            }
    }

    fun printReturnOnInvestment(returnOnInvestment: Double) {
        println("총 수익률은 ${String.format("%.2f", returnOnInvestment)}입니다. (${makeProfitOrLossStatus(returnOnInvestment)})")
    }

    private fun makeProfitOrLossStatus(returnOnInvestment: Double): String =
        "기준이 1이기 때문에 결과적으로 ${if (returnOnInvestment > 1) "이득이라는" else "손해라는"} 의미임"
}

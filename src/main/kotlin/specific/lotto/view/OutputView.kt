package specific.lotto.view

import specific.lotto.domain.Money
import specific.lotto.domain.Rank
import specific.lotto.domain.Ticket
import specific.lotto.domain.WinningResult

object OutputView {
    fun printTickets(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.numbers.sortedBy { number -> number.value })
        }
    }

    fun printWinningResult(winningResult: WinningResult) {
        println("당첨 통계")
        println("---------")
        Rank.FOURTH.run { "3개 일치 (${prize}원)- ${winningResult.aggregatedData[this]}개" }
        Rank.THIRD.run { "4개 일치 (${prize}원)- ${winningResult.aggregatedData[this]}개" }
        Rank.SECOND.run { "5개 일치 (${prize}원)- ${winningResult.aggregatedData[this]}개" }
        Rank.FIRST.run { "6개 일치 (${prize}원)- ${winningResult.aggregatedData[this]}개" }
    }

    fun printReturnOnInvestment(money: Money) {
        val returnOnInvestment: Double = money.calculateReturnOnInvestment()
        println("총 수익률은 ${String.format("%.2f", )}입니다. (${makeProfitOrLossStatus(returnOnInvestment)})")
    }

    private fun makeProfitOrLossStatus(returnOnInvestment: Double): String =
        "기준이 1이기 때문에 결과적으로 ${if (returnOnInvestment > 1) "이득이라는" else "손해라는"} 의미임"
}

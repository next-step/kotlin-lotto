package specific.lotto.view

import specific.lotto.domain.Money
import specific.lotto.domain.Ticket
import specific.lotto.domain.WinningResult

object OutputView {
    fun printTickets(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.numberCombination.numbers)
        }
    }

    fun printWinningResult(winningResult: WinningResult) {
        println("당첨 통계")
        println("---------")
        winningResult.aggregatedData.forEach { (rank, count) ->
            println("${rank.countOfSameNumber}개 일치 (${rank.prize}원)- ${count}개")
        }
    }

    fun printReturnOnInvestment(money: Money, winningResult: WinningResult) {
        val returnOnInvestment = (winningResult.totalPrize.toDouble() / money.principal)
        println(
            """
            총 수익률은 ${String.format("%.2f", returnOnInvestment)}입니다.
            (기준이 1이기 때문에 결과적으로 
            ${if (returnOnInvestment > 1) "이득이라는" else "손해라는"} 
            의미임)
            """.trimIndent().replace("\n", "")
        )
    }
}

package lotto.view

import lotto.model.ProfitCalculator
import lotto.model.Ticket

object ResultView {
    fun renderTickets(tickets: List<Ticket>) {
        tickets.forEach { println(it.numbers) }
    }

    fun renderResults(ticketPrice: Int, results: List<Int>, winningMoney: List<Int>) {
        println("당첨 통계")
        println("---------")
        winningMoney.forEachIndexed() { index, money ->
            if (money > 0) {
                println("${index}개 일치 (${money}원) - ${results[index]}개")
            }
        }
        println("총 수익률은 ${String.format("%.2f", ProfitCalculator.calculate(ticketPrice, results, winningMoney))}입니다.")
    }
}

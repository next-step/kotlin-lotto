package lotto.ui

import lotto.entity.LottoTicket
import lotto.entity.Rank

class ResultView {
    fun showLottoTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println(
                ticket.numbers
            )
        }
        println()
    }

    fun showMatchResult(money: Int, winningRanks: Map<Int, Int>) {
        println("\n당첨 통계")
        println("---------")
        var sum = 0
        winningRanks.onEach { it ->
            println("${it.key}개 일치 (${Rank.find(it.key)?.winningMoney}원) - ${it.value}개")
            sum += it.value * Rank.find(it.key)?.winningMoney!!
        }
        println(String.format("총 수익률은 %.2f 입니다.", sum.toDouble() / money))
    }
}

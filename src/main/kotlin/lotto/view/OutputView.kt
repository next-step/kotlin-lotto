package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoTicket

class OutputView {
    fun printTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }.joinToString(", ", "[", "]"))
        }
    }

    fun printStat(winningInfo: Map<LottoPrize, Int>) {
        println("\n당첨 통계\n---------")
        LottoPrize.values()
            .filter { it.money > 0 }
            .sortedBy { it.matchedCount }
            .forEach { println("${it.matchedCount}개 일치 (${it.money}원) - ${winningInfo[it] ?: 0}개") }
    }

    fun printRevenue(total: Int, profit: Int) {
        println("총 수익률은 %.2f 입니다.".format(profit.toDouble() / total))
    }
}

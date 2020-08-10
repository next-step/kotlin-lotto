package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.Rank

object OutputView {

    fun printLottoTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.lottoNumbers.map { it -> it.number }) }
    }

    fun printLottoResults(results: List<Rank>) {
        for (result in Rank.values()) {
            printLottoResult(result, results.filter { it == result }.size)
        }
    }

    private fun printLottoResult(result: Rank, size: Int) {
        if (result == Rank.ELSE) return
        println("${result.matchCount}개 일치 (${result.prizeMoney}) - ${size}개")
    }

    fun printProfitRatio(ratio: Double) {
        println("총 수익률은 %.2f 입니다".format(ratio))
    }
}

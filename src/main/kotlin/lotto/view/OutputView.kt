package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.Rank

object OutputView {

    fun printLottoTickets(tickets: LottoTickets) {
        println("${tickets.lottoTickets.size}개를 구매했습니다.")
        tickets.lottoTickets.forEach { ticket -> println(ticket.lottoNumbers.map { numbers -> numbers.number }) }
    }

    fun printLottoResults(results: List<Rank>) {
        for (result in Rank.values()) {
            printLottoResult(result, results.filter { it == result }.size)
        }
    }

    private fun printLottoResult(result: Rank, size: Int) {
        if (result == Rank.ELSE) return
        var hasBonusBall: String = ""
        if (result.bonusBall) hasBonusBall = ",보너스볼 일치"

        println("${result.matchCount}개 일치" + hasBonusBall + "(${result.prizeMoney}원)- ${size}개")
    }

    fun printProfitRatio(ratio: Double) {
        print("총 수익률은 %.2f입니다. ".format(ratio))
        if (ratio < 1) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}

package lotto.view

import lotto.domain.LottoRank
import lotto.domain.LottoResults
import lotto.domain.LottoTickets

object OutputView {
    fun printPurchaseResult(lottoTickets: LottoTickets) {
        val ticketCount = lottoTickets.tickets.size
        println(message = "$ticketCount 개를 구매했습니다.")
        for (lottoTicket in lottoTickets.tickets) {
            println(lottoTicket.lottoNumbers)
        }
    }

    fun printResults(
        results: LottoResults,
        amount: Int,
    ) {
        println("당첨 통계")
        println("---------")
        results.getResults()
            .filter { it.rank != LottoRank.BLANK_PLACE }
            .sortedBy { it.rank.matchCount }
            .forEach { result ->
                println("${result.rank.matchCount}개 일치 (${result.rank.prize}원)- ${result.count}개")
            }

        val totalPrize = results.totalPrize()
        val rateOfReturn = totalPrize.toDouble() / amount
        println("총 수익률은 %.2f 입니다.".format(rateOfReturn))
//        val rankCounts = results.countByRank()
//        LottoRank.entries.forEach { rank ->
//            val count = rankCounts[rank] ?: 0
//            println("${rank.matchCount} 개 일치 (${rank.prize}원)- ${count}개")
//        }
//        val reteOfReturn = results.totalPrize() / amount
//        print("총 수익률은 ${reteOfReturn}입니다.")
        if (rateOfReturn < 1) {
            println("기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
}

package lotto.view

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.LottoResults
import lotto.domain.LottoTickets

object OutputView {
    fun printPurchaseResult(lottoTickets: LottoTickets) {
        val ticketCount = lottoTickets.size
        println(message = "$ticketCount 개를 구매했습니다.")
        for (lottoTicket in lottoTickets) {
            println(lottoTicket.map { it.getNumber() })
        }
    }

    fun printResults(
        results: LottoResults,
        amount: Int,
    ) {
        println()
        println("당첨 통계")
        println("---------")
        results.findAllSortedByPrize()
            .filter { it.rank != LottoRank.BLANK_PLACE }
            .forEach { result ->
                print("${result.rank.matchCount}개 일치")
                printSecondPlace(result)
                println("(${result.rank.prize}원)- ${result.count}개")
            }

        val totalPrize = results.totalPrize()
        val rateOfReturn = totalPrize.toDouble() / amount
        print("총 수익률은 %.2f 입니다.".format(rateOfReturn))

        if (rateOfReturn < 1) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }

    private fun printSecondPlace(result: LottoResult) {
        if (result.rank == LottoRank.SECOND_PLACE) {
            print(", 보너스 볼 일치")
        }
    }
}

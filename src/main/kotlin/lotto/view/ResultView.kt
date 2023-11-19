package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.LottoTicketWinningInfo

object ResultView {

    fun printPurchasedLottos(lottoTickets: List<LottoTicket>) {

        println("${lottoTickets.size}개를 구매했습니다.")

        lottoTickets.forEach {
            println(it.lottoNumbers.sorted())
        }
        println()
    }

    fun printWinningStatistics(lottoTicketWinningInfos: List<LottoTicketWinningInfo>) {
        println("\n당첨 통계\n---------")
        lottoTicketWinningInfos.sortedBy { it.lottoPrize.matchCount }.forEach {
            val lottoPrize = it.lottoPrize
            val winningLottoCount = it.winningLottoTicketCount
            println("${lottoPrize.matchCount}개 일치 (${lottoPrize.prizeMoney})- ${winningLottoCount}개")
        }
    }

    fun printTotalRateOfReturn(totalRateOrReturn: Double) {
        val formattedTotalRateOfReturn = String.format("%.2f", totalRateOrReturn)
        print("총 수익률은 ${formattedTotalRateOfReturn}입니다.")

        when {
            totalRateOrReturn < 1.0 -> println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
            totalRateOrReturn > 1.0 -> println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)")
            else -> println("(기준이 1이기 때문에 결과적으로 본전이라는 의미임)")
        }
    }
}

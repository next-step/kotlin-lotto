package lotto.view

import lotto.domain.LottoGameResult
import lotto.domain.LottoPrize
import lotto.domain.LottoTicket

object ResultView {

    fun printPurchasedLottos(lottoTickets: List<LottoTicket>) {

        println("${lottoTickets.size}개를 구매했습니다.")

        lottoTickets.forEach { lottoTicket ->
            val numbers = lottoTicket.lottoNumbers.lottoNumbers.map { it.number }
            println(numbers.sorted())
        }
        println()
    }

    fun printLottoGameResult(lottoGameResult: LottoGameResult) {
        println("\n당첨 통계\n---------")
        printWinningLottoTicketCountByLottoPrize(lottoGameResult)
        printTotalRateOfReturn(lottoGameResult.totalRateOfReturn)
    }

    private fun printWinningLottoTicketCountByLottoPrize(lottoGameResult: LottoGameResult) {
        LottoPrize.values().sortedBy { it.matchCount }.forEach { lottoPrize ->
            val winningLottoCount = lottoGameResult.getWinningLottoTicketCountBy(lottoPrize)
            println("${lottoPrize.matchCount}개 일치 (${lottoPrize.prizeMoney})- ${winningLottoCount}개")
        }
    }

    private fun printTotalRateOfReturn(totalRateOrReturn: Double) {
        val formattedTotalRateOfReturn = String.format("%.2f", totalRateOrReturn)
        print("총 수익률은 ${formattedTotalRateOfReturn}입니다.")

        when {
            totalRateOrReturn < 1.0 -> println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
            totalRateOrReturn > 1.0 -> println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)")
            else -> println("(기준이 1이기 때문에 결과적으로 본전이라는 의미임)")
        }
    }
}

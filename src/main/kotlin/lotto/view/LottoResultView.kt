package lotto.view

import lotto.model.LottoPrize
import lotto.model.LottoResult
import lotto.utils.MatchedCount
import lotto.utils.Prize
import lotto.utils.TicketCount

class LottoResultView {
    fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        printLottoPrizes(lottoResult)
        printRevenueRate(lottoResult)
    }

    private fun printLottoPrizes(lottoResult: LottoResult) {
        val grouped = lottoResult.groupWinningTicketCountByMatchedCount()

        grouped.forEach { (matchedCount, ticketCount) ->
            val prize = LottoPrize.of(matchedCount)

            printLottoPrize(matchedCount, prize.prize, ticketCount)
        }
    }

    private fun printLottoPrize(matchedCount: MatchedCount, prize: Prize, ticketCount: TicketCount) {
        println("${matchedCount}개 일치 (${prize}원)- ${ticketCount}개")
    }

    private fun printRevenueRate(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.revenueRate}입니다.\n")
    }
}
